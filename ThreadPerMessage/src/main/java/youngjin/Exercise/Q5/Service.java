package youngjin.Exercise.Q5;

public class Service extends Thread {

    public static void service() {
        System.out.print("service");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("done.");
    }

    @Override
    public void run() {
        this.service();
    }
}
