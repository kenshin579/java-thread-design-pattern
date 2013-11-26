package youngjin.Exercise.Q9;

public class Something {
    public static void method(long x) throws InterruptedException {
        if (x != 0) {
            Object object = new Object();
            synchronized (object) {
                object.wait(x);
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("sleep");
            method(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
