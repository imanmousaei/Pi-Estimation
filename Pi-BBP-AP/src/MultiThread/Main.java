package MultiThread;

import Util.BBPRunnable;

import java.util.ArrayList;

import static Util.Constants.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();

        int eachThreadSize = (int) (INF / THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread t = new Thread(new BBPRunnable(i * eachThreadSize, (i + 1) * eachThreadSize));
            threads.add(t);
        }

        long start = System.currentTimeMillis();

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("MultiThread : " + (end - start) + " ms , pi = " + BBPRunnable.pi);
    }
}
