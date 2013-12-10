package youngjin.Exercise.Q6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TASKS = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        try {
            for (int t = 0; t < TASKS; t++) {
                Runnable printTask = new Runnable() {
                    public void run() {
                        Log.println("Hello!");
                        Log.close();
                    }
                };
                service.execute(printTask);
            }
        } finally {
            service.shutdown();
        }
    }
}
