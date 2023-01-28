package utilities;

public class Waiter {

    // pause method
    public static void pause(int seconds) {
        // Thread.sleep is a checked exception, thus surround in try/catch block
        try {
            Thread.sleep((seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
