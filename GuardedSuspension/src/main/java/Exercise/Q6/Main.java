package Exercise.Q6;


public class Main {
    public static void main(String[] args) {
        // ����åɤ�ư����
        RequestQueue requestQueue = new RequestQueue();
        Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
        Thread bobby = new ServerThread(requestQueue, "Bobby", 265358L);
        alice.start();
        bobby.start();

        // ��10���Ԥ�
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        // interrupt�᥽�åɤ�Ƥ�
        System.out.println("***** calling interrupt *****");
        alice.interrupt();
        bobby.interrupt();
    }
}
