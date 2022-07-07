import javax.xml.soap.SAAJResult;

public class JoinRunnable extends Thread {

    private String name;

    public JoinRunnable(String name) {
        super(name);
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        for (int i = 0; i <= 10; i++){
            System.out.println(currentThreadName + " полон на " + i + "/10");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(currentThreadName + " полон. \n");
    }
}
