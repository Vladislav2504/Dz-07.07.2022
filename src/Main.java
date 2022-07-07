import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock locker = new ReentrantLock();
        JoinRunnable t1 = new JoinRunnable("Storage A");
        JoinRunnable t2 = new JoinRunnable("Storage B");
        JoinRunnable t3 = new JoinRunnable("Storage C");

        t3.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t1.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}