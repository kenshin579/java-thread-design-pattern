package youngjin.volatile3;

class Something {
    private int x = 0;
    private volatile boolean valid = false;

    public void write() {
        x = 123;
        valid = true;
    }

    public void read() {
        if (valid) {
            System.out.println(x);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Something obj = new Something();

        //
        new Thread() {
            public void run() {
                obj.write();
            }
        }.start();

        //
        new Thread() {
            public void run() {
                obj.read();
            }
        }.start();
    }
}
