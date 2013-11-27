package youngjin.WorkerThread;

import java.util.Random;

public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /*
     * Q: 여기서 this가 의미하는 것은?
     * A: request 객체 인데, System.out.println에서는 implicit하게 toString()를 호출함
     */
    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
