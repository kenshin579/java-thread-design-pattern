package youngjin.TwoPhaseTermination;

/**
 *
 */
public class CountupThread extends Thread {
    private long counter = 0;
    // volatitle로 왜 선언을 해야 하나?
    private volatile boolean shutdownRequested = false;

    /**
     * Q1.왜 interrupt 메서드를 호출해야 하나?
     * A.sleep을 하고 있던 wait을 해서 wait 셋에 있던 interrupt() 요청없이는 바로 중단이 안되기 때문에
     * <p/>
     * Q2.왜 인터럽트 상태 테스트만으로는 충분하지 않나요? (왜 shutdownRequested 플래그가 없어도 괜찮지 않나?)
     * A.interrupt()로 인해 InterruptException이 통보되면 인터럽트 상태에서 벗어나게 된다.
     * -- 아직 잘 이해가 안됨...
     */
    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
            // InterruptException을 무시함

        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
