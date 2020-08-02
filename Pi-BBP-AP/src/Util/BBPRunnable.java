package Util;

import org.jscience.mathematics.number.Real;

import java.util.concurrent.locks.ReentrantLock;

import static Util.Constants.*;

public class BBPRunnable implements Runnable {
    private int start;
    private int end;
    public static Real pi = ZERO;
    ReentrantLock piLock = new ReentrantLock();

    public BBPRunnable(int start, int end) { // [start,end)
        this.start = start;
        this.end = end;
    }

    public static void resetPi(){
        pi = ZERO;
    }

    // formula : https://wikimedia.org/api/rest_v1/media/math/render/svg/af6bc360851499dd2ab2a90bee03fbe2040089d5

    @Override
    public void run() {
        Real.setExactPrecision(1000);
        for (int k = start; k < end; k++) {
            Real inParantez = FOUR.divide(Real.valueOf(8 * k + 1));
            inParantez = inParantez.minus(TWO.divide(Real.valueOf(8 * k + 4)));
            inParantez = inParantez.minus(ONE.divide(Real.valueOf(8 * k + 5)));
            inParantez = inParantez.minus(ONE.divide(Real.valueOf(8 * k + 6)));
            Real term;
            if (k == 0) {
                term = inParantez;
            }
            else {
                term = ONE.divide(SIXTEEN.pow(k)).times(inParantez);
            }

            piLock.lock();
            pi = pi.plus(term);
            piLock.unlock();
        }
    }
}
