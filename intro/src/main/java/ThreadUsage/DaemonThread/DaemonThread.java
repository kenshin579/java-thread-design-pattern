package ThreadUsage.DaemonThread;

/**
 * 데몬 쓰레드의 특징
 * - 일반 쓰레드가 모두 종료가 되면 데몬 쓰레드는 강제적으로 자동종료된다.
 * <p/>
 * 참고: http://warmz.tistory.com/349
 */
class DaemonThread implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThread());
        t.setDaemon(true);
//        t.setDaemon(false); // 무한 루프를 돌게 됨(이유: 위에 있는 설명 참조)
        t.start();

        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(i);

            if (i == 5)
                autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
            }

            if (autoSave)
                autoSave();
        }
    }

    private void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
