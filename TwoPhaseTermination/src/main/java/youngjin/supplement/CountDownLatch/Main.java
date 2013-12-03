package youngjin.supplement.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch란? 지정한 횟수만큼 어떤 액션이 일어나것을 기다림
 * - CountDownLatch 클래스의 인스턴슨느 카운트다운 밖에 할 수 없음
 * - 한번 카운트가 0이되면 await 메서드를 호출해도 바로 돌아와 버림
 */
public class Main {
    private static final int TASKS = 10; // 일의 개수

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch doneLatch = new CountDownLatch(TASKS);

        try {
            // 일 시작
            for (int t = 0; t < TASKS; t++) {
                service.execute(new MyTask(doneLatch, t));
            }
            System.out.println("AWAIT");

            // 일이 종료되기를 기다림
            doneLatch.await();
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
