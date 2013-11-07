package ThreadUsage.ThreadMethodEx;

class JoinMethodEx {
    public static void main(String[] args) {
        ThreadEx1 t1 = new ThreadEx1();
        ThreadEx2 t2 = new ThreadEx2();

        t1.start();
        t2.start();

        try {
            t1.join();  // t1의 작업이 끝날때까지 기다린다.
            t2.join();  // t2의 작업이 끝날때까지 기다린다.
        } catch (InterruptedException e) {
        }

        System.out.println("종료");
    }
}

class ThreadEx1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++) ;
        }
    }
}

class ThreadEx2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++) ;
        }
    }
}
