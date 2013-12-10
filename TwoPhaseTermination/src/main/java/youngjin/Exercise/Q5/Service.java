package youngjin.Exercise.Q5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class Service {
    static Thread serviceThread = null;
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void service() {
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print("service");

                    for (int i = 0; i < 50; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println("interrupted");
                            break;
                        }
                    }
                    System.out.println("done.");
                }
            });
        } catch (RejectedExecutionException re) {
            System.out.println("RejectedExecutionException");
        }

//        serviceThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("service");
//                for (int i = 0; i < 50; i++) {
//                    System.out.print(".");
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.out.println("interrupted");
//                        break;
//                    }
//                }
//                System.out.println("done.");
//            }
//        });
//        serviceThread.start();
    }

    public static void cancel() {
//        serviceThread.interrupt();
        executorService.shutdown();
    }
}
