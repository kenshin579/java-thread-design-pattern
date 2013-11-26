package youngjin.supplement.Executor;

import java.util.concurrent.Executor;

/**
 * Host 클래스를 이요하는 측에서 처리의 실행을 제어할 수 있음
 */
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // 생성하는 것까지 감추어졌다는 의미는:여기에 ThreadFactory 생성하는 부분이 없다는 것임
        executor.execute(
                new Runnable() {
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
