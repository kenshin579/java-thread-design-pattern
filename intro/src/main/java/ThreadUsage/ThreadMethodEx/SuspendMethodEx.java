package ThreadUsage.ThreadMethodEx;

class SuspendMethodEx {
    public static void main(String[] args) {
        ThreadEx r1 = new ThreadEx();
        ThreadEx r2 = new ThreadEx();
        ThreadEx r3 = new ThreadEx();

        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            r1.suspend(); // 쓰레드의 suspend()가 아니다!
            Thread.sleep(2000);
            r2.suspend();
            Thread.sleep(3000);
            r1.resume();
            Thread.sleep(3000);
            r1.stop();
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch (InterruptedException e) {
        }
    }
}

class ThreadEx implements Runnable {
    boolean suspended = false;
    boolean stopped = false;

    public void run() {
        while (!stopped) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
}
