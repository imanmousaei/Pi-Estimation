package MultiThread;

import Util.MonteCarloRunnable;

import java.util.ArrayList;

import static Util.Constants.POINT_COUNT;
import static Util.Constants.THREAD_COUNT;
import static Util.Util.calculatePi;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread t = new Thread(new MonteCarloRunnable(POINT_COUNT / THREAD_COUNT));
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

        System.out.println("MultiThread : " + (end - start) + " ms , pi = " + calculatePi());
    }
}
