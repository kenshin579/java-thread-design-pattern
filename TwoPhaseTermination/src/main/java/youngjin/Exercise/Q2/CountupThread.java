package youngjin.Exercise.Q2;

public class CountupThread extends Thread {
    // �����󥿤���
    private long counter = 0;

    // ��λ�׵�
    public void shutdownRequest() {
        interrupt();
    }

    // ư��
    public void run() {
        try {
            while (!isInterrupted()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    // ���
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    // ��λ����
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
