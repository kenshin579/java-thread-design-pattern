package youngjin.Exercise.Q7;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");
        }
    }

    private static void magic(final Object obj) {
        synchronized (obj) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("(여기에서 표시를 정지. CTRL+C를 눌려주세요)");
                    for (; ; ) {
//                        System.out.print(".");
                    }
                }
            }).start();
        }

    }

}
