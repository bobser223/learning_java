package labs.lab009;

import hw.hw009.Log;

import java.util.concurrent.locks.ReentrantLock;

public class A09_02 {

    public static void main(String[] args) throws InterruptedException {
        double T1 = 1.0;   // min transit (s)  <-- зробив коректний порядок
        double T2 = 2.0;   // max transit (s)
        double T3 = 0.01;  // min arrive (s)
        double T4 = 0.10;  // max arrive (s)
        int n = 10;

        ReentrantLock lock = new ReentrantLock(true);

        Log.print("Start");

        Thread[] trains = new Thread[n];

        Log.print("Start");
        for(int i = 0; i < n; i++){
            long arriveTime = (long) ((Math.random() * (T4 - T3) + T4) * 1000);
            long transitTime = (long) ((Math.random() * (T2 - T1) + 24) * 1000);

            int j = i;
            trains[i] = new Thread(() -> train(j, arriveTime, transitTime, lock));
            trains[i].start();
        }

        for (int i = 0; i < n; i++)
            trains[i].join();

        Log.print("End");
    }

    public static void train(int i, long arriveTime, long transitTime, ReentrantLock lock){
        Thread.currentThread().setName("Train " + i);
        try{
            Thread.sleep(arriveTime);
            Log.print("Train " + i + " arrived");
            lock.lock();
            Log.print("Train " + i + " starts passing");

            Thread.sleep(transitTime);
            lock.unlock();
            Log.print("Train " + i + " passed");
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
