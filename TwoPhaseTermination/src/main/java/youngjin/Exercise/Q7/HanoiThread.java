package youngjin.Exercise.Q7;

public class HanoiThread extends Thread {
    // ��λ�׵᤬�Ф��줿��true
    private volatile boolean shutdownRequested = false;
    // ��λ�׵᤬�Ф��줿����
    private volatile long requestedTimeMillis = 0;

    // ��λ�׵�
    public void shutdownRequest() {
        requestedTimeMillis = System.currentTimeMillis();
        shutdownRequested = true;
        interrupt();
    }

    // ��λ�׵᤬�Ф��줿���ɤ����Υƥ���
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // ư��
    public void run() {
        try {
            for (int level = 0; !isShutdownRequested(); level++) {
                System.out.println("==== Level " + level + " ====");
                doWork(level, 'A', 'B', 'C');
                System.out.println("");
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    // ���
    private void doWork(int level, char posA, char posB, char posC) throws InterruptedException {
        if (level > 0) {
            doWork(level - 1, posA, posC, posB);
            System.out.print(posA + "->" + posB + " ");
            doWork(level - 1, posC, posB, posA);
        }
    }

    // ��λ����
    private void doShutdown() {
        long time = System.currentTimeMillis() - requestedTimeMillis;
        System.out.println("doShutdown: Latency = " + time + " msec.");
    }
}
