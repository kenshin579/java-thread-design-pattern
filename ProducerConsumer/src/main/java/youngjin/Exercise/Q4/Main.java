package youngjin.Exercise.Q4;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        MakerThread m1 = new MakerThread("MakerThread-1", table, 31415);
        MakerThread m2 = new MakerThread("MakerThread-2", table, 92653);
        MakerThread m3 = new MakerThread("MakerThread-3", table, 58979);

        EaterThread e1 = new EaterThread("EaterThread-1", table, 32384);
        EaterThread e2 = new EaterThread("EaterThread-2", table, 62643);
        EaterThread e3 = new EaterThread("EaterThread-3", table, 38327);

        m1.start();
        m2.start();
        m3.start();

        e1.start();
        e2.start();
        e3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // terminate
        m1.interrupt();
        m2.interrupt();
        m3.interrupt();

        e1.interrupt();
        e2.interrupt();
        e3.interrupt();
    }
}
