package youngjin.singlethreaded;

/**
 * BROKEN 메시지 없이 정상 동작함
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();

        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
