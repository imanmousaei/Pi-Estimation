package Util;

import java.util.concurrent.locks.ReentrantLock;

import static Util.Constants.POINT_COUNT;
import static Util.Constants.R;
import static Util.Util.distanceFromCenter;
import static Util.Util.getRandomNumberInRange;

public class MonteCarloRunnable implements Runnable {
    public static long pointsInCircle = 0;
    public static long pointsInSquare = 0;
    public long cnt = 0;

    public MonteCarloRunnable(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for (int i = 1; i <= cnt; i++) {
            double x = getRandomNumberInRange(-R, R);
            double y = getRandomNumberInRange(-R, R);
            double dis = distanceFromCenter(x, y);

            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            if (dis < R) {
                pointsInCircle++;
            }
            pointsInSquare++;
            lock.unlock();

        }

    }

}
