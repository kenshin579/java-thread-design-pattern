package youngjin.Exercise.Q8;

public class Main {
    public static void main(String[] args) {
        // ����åɤ���������
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        System.out.print("*");
                    }
                }
            }
        };

        // ����åɤ�ư����
        t.start();

        // 5���Ԥ�
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // ����åɤ˰��٤���interrupt�򤫤���
        t.interrupt();
    }
}
