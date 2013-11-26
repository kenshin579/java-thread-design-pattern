package youngjin.supplement.Executors;

import java.util.concurrent.Executors;

/**
 * Executors 클래스에는 유틸리티적인 클래스 메서드가 다수 모여 있음
 * - Executors.defaultThreadFactory() 로 현재의 디폴트 설정을 ThreadFactory 객체를 구할 수 있음
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
                Executors.defaultThreadFactory()
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
