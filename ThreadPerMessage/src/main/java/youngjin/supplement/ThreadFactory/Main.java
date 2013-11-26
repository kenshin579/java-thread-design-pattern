package youngjin.supplement.ThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * ThreadFactory는 쓰레드 생성을 추상화한 인터페이스이며, 인수로 부여하는 Runnable 객체는 쓰레드가 실행하는 처리의 내용을 나타냄
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
