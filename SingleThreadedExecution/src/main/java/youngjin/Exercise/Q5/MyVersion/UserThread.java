package youngjin.Exercise.Q5.MyVersion;

public class UserThread extends Thread {
    private final SecurityGate gate;

    public UserThread(SecurityGate gate) {
        this.gate = gate;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " BEGIN");

        gate.enter();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gate.exit();

    }
}
