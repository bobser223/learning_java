package labs.lab009;

import hw.hw009.Log;

import java.util.concurrent.ArrayBlockingQueue;

public class A09_01 {

    public static void main(String[] args) throws InterruptedException {
        double T1 = 2.0;
        double T2 = 1.0;
        int n = 10;

        long putTime = (long) (T1 * 1000);
        long getTime = (long) (T2 * 1000);

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(n);

        var t1 = new Thread(() -> put(n, putTime, queue));
        var t2 = new Thread(()-> get(getTime, queue));

        t1.setDaemon(true);


        System.out.println("Main thread");
        t1.start();
        t2.start();

//        t1.join();
        t2.join();
        System.out.println("Main thread end");
    }

    public static void put(int count, long time, ArrayBlockingQueue<String> queue){
        Thread.currentThread().setName("Put");
        try{
            for (int i = 0; i < count;i++){
                String msg = "MESSAGE " + i;
                Log.print("creating " + msg);
                Thread.sleep(time);
                Log.print(msg+" is created");
                queue.put(msg);
            }
            queue.put("");

        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


    public static void get(long time, ArrayBlockingQueue<String> queue){
        Thread.currentThread().setName("GET");

        try{
            while(true){
                String msg = queue.take();
                Log.print("extracted " + msg);
                if (msg.isEmpty())
                    break;
                Thread.sleep(time);
                Log.print(msg+" is processed");
            }

        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
