package youngjin.supplement.ThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * Host 클래스는 new Thread(...)가 없기 때문에 java.lang.Thread 클래스에 의존하지 않음
 * - Host 클래스를 이용하는 측에서 쓰레드 생성의 상세 내용을 제어할 수 있게 됨(how??)
 */
public class Host {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        threadFactory.newThread(
                new Runnable() {
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
