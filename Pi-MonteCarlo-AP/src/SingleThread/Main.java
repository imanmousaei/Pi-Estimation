package SingleThread;

import Util.MonteCarloRunnable;

import static Util.Constants.POINT_COUNT;
import static Util.Util.calculatePi;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MonteCarloRunnable(POINT_COUNT));

        long start = System.currentTimeMillis();
        t.start();
        t.join();
        long end = System.currentTimeMillis();

        System.out.println("SingleThread : " + (end-start) + " ms , pi = " + calculatePi() );
    }
}
