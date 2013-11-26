package youngjin.supplement.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ExecutorService의 서브 인터페이스이며 처리의 실행을 지연시키는 기능을 가지고 있음
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Host host = new Host(
                scheduledExecutorService
        );
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            scheduledExecutorService.shutdown();
            System.out.println("main END");
        }
    }
}
