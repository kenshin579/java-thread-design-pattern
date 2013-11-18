package youngjin.supplement.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanger 클래스를 사용해서 2개의 버퍼를 서로 교환함으로써 작업을 진행함
 * - 생산된 문자는 ProducerThread에서 ConsumerThread 쪽 방향으로만 흘러감
 * - 빈 버퍼를 보면 반대로 ConsumerThread 쪽에서 ProducerThread로 흐름
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<char[]>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];

        new ProducerThread(exchanger, buffer1, 314159).start();
        new ConsumerThread(exchanger, buffer2, 265358).start();
    }
}
