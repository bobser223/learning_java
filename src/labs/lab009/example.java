package labs.lab009;

import java.util.TreeMap;

public class example {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.setDaemon(true);


        System.out.println("Main thread");
        t1.start();
        t2.start();

//        t1.join();
        t2.join();
        System.out.println("Main thread end");
    }
}


class Thread1 extends Thread {


    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            System.out.println("Thread1: " + i);
            System.out.flush();
            try{ // this block logicaly equal to Theread yrald
                Thread.sleep(0);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        for(int i = -1; i > -25; i--){
            System.out.println("Thread2: " + i);
            System.out.flush();
            Thread.yield();
        }
    }
}
