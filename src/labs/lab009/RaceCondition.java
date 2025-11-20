package labs.lab009;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTread());
        Thread t2 = new Thread(new MyTread());

        t1.setDaemon(true);


        System.out.println("Main thread");
        t1.start();
        t2.start();

//        t1.join();
        t2.join();
        System.out.println("Main thread end");

//        System.out.println("n = " + Data.n);
        System.out.println("m = " + Data.m.get());
    }
}


class Data{
    static public int n = 0;
    static public AtomicInteger m = new AtomicInteger(0);
}

class MyTread implements Runnable{

//    synchronized public static void addOne(){
//        Data.n++;
//    }
    public static void addOne(){
        Data.m.incrementAndGet();
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++){
            addOne();
        }
    }
}
