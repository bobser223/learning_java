package hw.hw009;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B09_03 {

    static public AtomicInteger unloadedCnt = new AtomicInteger(0);
    static public AtomicLong fixedTime = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        int N = 10;

        var lock = new Semaphore(N, true);

        int T1 = 1;
        int T2 = 2;

        int T3 = 3;

        int K1 = 1;
        int K2 = 2;

        int K3 = 3;

        int M = 12;


        assert T1 < T2;
        assert K1 < K2;

        Thread[] ships = new Thread[M];

        for(int i = 0; i < M; i++){
            int timeToWait = (int) ThreadLocalRandom.current().nextInt(T1, T2 + 1)*1000;
            Thread.sleep(timeToWait);

            int timePerContainer = T3*1000;
            int containersCnt = (int) ThreadLocalRandom.current().nextInt(K1, K2+1);


            int j = i;
            ships[i] = new Thread(() -> ship(j, lock, timePerContainer, containersCnt, K3));
            ships[i].start();

        }

        for(int i = 0; i < M; i++){
            ships[i].join();
        }

        System.out.println("Fixed time = " + fixedTime);




    }

    public static void ship(int j, Semaphore lock, int timePerContainer, int containersCnt, int suggestedUploaded){
        Thread.currentThread().setName("Ship " + j);

        Log.print("Ship entered");

        try{
            lock.acquire();

            Log.print("Ship unlocked");
            for (int i = 0; i < containersCnt; i++){
                Log.print("Container uploading " + i);
                Thread.sleep(timePerContainer);

                int uploaded = unloadedCnt.getAndIncrement() + 1;

                if (uploaded == suggestedUploaded) {
                    Log.print("Uploaded " + uploaded + " at time " + LocalDateTime.now() + " by thread " + Thread.currentThread().getName());
                    fixedTime.set(System.currentTimeMillis());
                }


            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            Log.print("Ship exiting");
            lock.release();
        }
    }

}


