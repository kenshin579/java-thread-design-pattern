package youngjin.Exercise.Q4;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new ClientThread("Alice");
//        System.out.println(Log.tsLogCollection.get("Alice-log.txt") != null ? "okay" : "not okay");
        thread1.start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
