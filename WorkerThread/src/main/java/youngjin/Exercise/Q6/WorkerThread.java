package youngjin.Exercise.Q6;

public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while (true) {
                Request request = channel.takeRequest();
                request.execute();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "...stopped");
        }
    }
}
