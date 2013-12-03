package youngjin.supplement.CyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 모든 쓰레드가 N 단계를 종료하기 전까지는 누구도 N+1단계로 갈 수 없는 패턴...
 */
public class Main {
    private static final int THREADS = 3; // 쓰레드의 수

    public static void main(String[] args) {
        System.out.println("BEGIN");

        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        //배리어가 해제될 때의 액션
        Runnable barrierAction = new Runnable() {
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        // 단계를 맞추는 CyclicBarrier
        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

        // 일의 종료를 조사하는 CountDownLatch
        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            // 일 시작
            for (int t = 0; t < THREADS; t++) {
                service.execute(new MyTask(phaseBarrier, doneLatch, t));
            }

            System.out.println("AWAIT");
            // 일의 종료를 기다림
            doneLatch.await();
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
