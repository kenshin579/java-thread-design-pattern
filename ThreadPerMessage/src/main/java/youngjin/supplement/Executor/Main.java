package youngjin.supplement.Executor;

import java.util.concurrent.Executor;

/**
 * Executor는 어떠한 '처리를 실행'하는 것을 추상화한 인터페이스이며 인수로 부여한느 Runnable 객체는 '실행하는 처리'의 내용을 나타냄
 * ThreadFactory vs. Executor
 * - ThreadFactory 인터페이스는 쓰레드 생성의 상세 내용을 감추고 있지만, 쓰레드를 생성하는 것 자체는 감추지 않음
 * - Executor 인터페이스를 이용하면 쓰레드의 생성까지도 감출 수 있음(??)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
                new Executor() {
                    public void execute(Runnable r) {
                        new Thread(r).start();
                    }
                }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
