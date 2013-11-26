package youngjin.supplement.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService 인터페이스는 반복하여 execute할 수 있는 서비스를 추상화 한 것
 * - 쓰레드를 매번 생성하지 않고 처리 실행후 마치고 쉬고 있는 쓰레드를 재사용할 수 있도록 해주는 인터페이스임
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");

        // 재사용할 수 있도록 해줌...
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(
                executorService
        );
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
