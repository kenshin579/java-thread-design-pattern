package youngjin.synchronize1;

class Something {
    private int x = 0;
    private int y = 0;

    public void write() {
        x = 100;
        y = 50;
    }

    public void read() {
        if (x < y) {
            System.out.println("x < y");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Something obj = new Something();

        // 쓰기 쓰레드 A
        new Thread() {
            public void run() {
                obj.write();
            }
        }.start();

        // 읽기 쓰레드 B
        new Thread() {
            public void run() {
                obj.read();
            }
        }.start();
    }
}
