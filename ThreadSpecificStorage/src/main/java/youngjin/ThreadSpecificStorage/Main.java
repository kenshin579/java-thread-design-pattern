package youngjin.ThreadSpecificStorage;

/**
 * 쓰레드 별로 Log 파일을 찍도록함
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
