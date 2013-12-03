package youngjin.Exercise.Q4;

public class GracefulThread extends Thread {
    // ��λ�׵᤬�Ф��줿��true
    private volatile boolean shutdownRequested = false;

    // ��λ�׵�
    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // ��λ�׵᤬�Ф��줿���ɤ����Υƥ���
    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // ư��
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    // ���
    protected void doWork() throws InterruptedException {
    }

    // ��λ����
    protected void doShutdown() {
    }
}
