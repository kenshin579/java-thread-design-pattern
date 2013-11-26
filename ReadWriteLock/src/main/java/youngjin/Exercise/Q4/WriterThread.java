package youngjin.Exercise.Q4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Database database;
    public static AtomicInteger count = new AtomicInteger(0);

    public WriterThread(Database database) {
        this.database = database;
    }

    public void run() {
        try {
            int num;

            for (; ; ) {
                num = count.incrementAndGet();
                database.assign(num, new String("string  " + num));
                System.out.println(Thread.currentThread().getName() + " writes " + num);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
        }
    }

}
