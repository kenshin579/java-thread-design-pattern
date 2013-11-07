package ThreadUsage.ThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * ThreadFactory 인터페이스를 이용하면 Runnable 인수로 부여하여 Thread의 인스턴스를
 * new로 작성하는 부분을 ThreadFactory 내부에 숨길수 있다.
 * - 이것의 장점은? 잘 모르겠음.
 * <p/>
 * 참고: 왜 ThreadFactory를 사용하는가, http://javahowto.blogspot.kr/2011/11/why-use-threadfactory.html
 */
public class Main {
    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Nice!")).start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }
}
