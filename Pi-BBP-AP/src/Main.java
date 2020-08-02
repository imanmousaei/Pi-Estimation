import Util.BBPRunnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SingleThread.Main.main(args);
        BBPRunnable.resetPi();
        MultiThread.Main.main(args);
    }
}
