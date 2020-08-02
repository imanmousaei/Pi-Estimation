package Util;

import java.util.Random;

public class Util {
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double distanceFromCenter(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public static double calculatePi() {
        return 4.00000 * MonteCarloRunnable.pointsInCircle / MonteCarloRunnable.pointsInSquare;
    }

}
