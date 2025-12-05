package hw.hw009;


import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class B09_01 {

    private static final String POISON_PILL = new String("POISON_PILL");

    public static void main(String[] args) throws InterruptedException {
        String path = "src/hw/hw009/";
        String inputFile = path + "input.txt";
        String outputFile1 = path + "out1.txt";
        String outputFile2 = path + "out2.txt";

        long T1 = 500;
        long T2 = 1000;
        long T3 = 1500;

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(inputFile, queue, T1);
        Consumer consumer1 = new Consumer("Consumer-1", queue, outputFile1, T2);
        Consumer consumer2 = new Consumer("Consumer-2", queue, outputFile2, T3);

        Log.print("Starting threads");

        producer.start();
        consumer1.start();
        consumer2.start();

        producer.join();

        queue.put(POISON_PILL);
        queue.put(POISON_PILL);

        consumer1.join();
        consumer2.join();

        Log.print("All threads finished");
    }

    static class Producer extends Thread {
        private final String inputFile;
        private final BlockingQueue<String> queue;
        private final long delayMillis;

        public Producer(String inputFile, BlockingQueue<String> queue, long delayMillis) {
            super("Producer");
            this.inputFile = inputFile;
            this.queue = queue;
            this.delayMillis = delayMillis;
        }

        @Override
        public void run() {
            Log.print("Producer started");
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Log.print("Read line: " + line);
                    queue.put(line);
                    Log.print("Enqueued line");
                    Thread.sleep(delayMillis);
                }
            } catch (IOException e) {
                Log.print("Producer I/O error: " + e.getMessage());
            } catch (InterruptedException e) {
                Log.print("Producer interrupted");
                Thread.currentThread().interrupt();
            }
            Log.print("Producer finished reading file");
        }
    }

    static class Consumer extends Thread {
        private final BlockingQueue<String> queue;
        private final String outputFile;
        private final long processTimeMillis;

        public Consumer(String name,
                        BlockingQueue<String> queue,
                        String outputFile,
                        long processTimeMillis) {
            super(name);
            this.queue = queue;
            this.outputFile = outputFile;
            this.processTimeMillis = processTimeMillis;
        }

        @Override
        public void run() {
            Log.print("Consumer started, outputFile=" + outputFile);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                while (true) {
                    String line = queue.take();
                    if (line == POISON_PILL) {
                        Log.print("Got POISON_PILL, exiting");
                        queue.put(POISON_PILL);
                        break;
                    }

                    Log.print("Got line: " + line);
                    try {
                        Thread.sleep(processTimeMillis);
                    } catch (InterruptedException e) {
                        Log.print("Consumer interrupted during processing");
                        Thread.currentThread().interrupt();
                        break;
                    }

                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                    Log.print("Processed and wrote line: " + line);
                }
            } catch (IOException e) {
                Log.print("Consumer I/O error: " + e.getMessage());
            } catch (InterruptedException e) {
                Log.print("Consumer interrupted while taking from queue");
                Thread.currentThread().interrupt();
            }
            Log.print("Consumer finished: " + getName());
        }
    }
}
