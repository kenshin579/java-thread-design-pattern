package youngjin.Exercise.Q7;

public class Main {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            // ����åɤε�ư
            HanoiThread t = new HanoiThread();
            t.start();

            // �������֤򤢤���
            Thread.sleep(10000);

            // ����åɤν�λ�׵�
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            // ����åɤν�λ���Ԥ�
            System.out.println("main: join");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
