package youngjin.Exercise.Q5.MyVersion;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Testing Gate, hit CTRL+C to exit.");
        SecurityGate gate = new SecurityGate();
        UserThread u1 = new UserThread(gate);
        UserThread u2 = new UserThread(gate);
        UserThread u3 = new UserThread(gate);
        UserThread u4 = new UserThread(gate);
        UserThread u5 = new UserThread(gate);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();

        u1.join();
        u2.join();
        u3.join();
        u4.join();
        u5.join();

        int counter = gate.getCounter();
        if (counter != 0) {
            System.out.println("SOMETHING WRONG!! counter = " + counter);
        }
    }
}
