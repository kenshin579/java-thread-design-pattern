package youngjin.Exercise.Q3;

public class Main {
    public static void main(String[] args) {
        new PrintThread("*").start();
        new PrintThread("+").start();
    }
}
