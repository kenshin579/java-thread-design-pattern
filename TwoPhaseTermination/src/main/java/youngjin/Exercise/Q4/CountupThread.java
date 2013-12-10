package youngjin.Exercise.Q4;

public class CountupThread extends GracefulThread {
    private long counter = 0;

//    public void shutdownRequest() {
//        interrupt();
//    }
//
//    public void run() {
//        try {
//            while (!isInterrupted()) {
//                doWork();
//            }
//        } finally {
//            doShutdown();
//        }
//    }
//
//    private void doWork() {
//        counter++;
//        System.out.println("doWork: counter = " + counter);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void doShutdown() {
//        System.out.println("doShutdown: counter = " + counter);
//    }
}
