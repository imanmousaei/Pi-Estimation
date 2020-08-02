package SingleThread;

import Util.BBPRunnable;

import static Util.Constants.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BBPRunnable(0,INF));

        long start = System.currentTimeMillis();
        t.start();
        t.join();
        long end = System.currentTimeMillis();

        System.out.println("SingleThread : " + (end-start) + " ms , pi = " + BBPRunnable.pi );
    }
}
