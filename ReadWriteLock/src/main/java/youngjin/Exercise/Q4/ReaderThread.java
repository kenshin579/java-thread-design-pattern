package youngjin.Exercise.Q4;

import java.util.Iterator;

public class ReaderThread extends Thread {
    private final Database database;

    public ReaderThread(Database database) {
        this.database = database;
    }

    public void run() {

        Iterator<Integer> iterator = database.getKey().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            Integer key = iterator.next();
            String value = (String) database.retrieve(key);
            System.out.println(Thread.currentThread().getName() + " reads " + value);


        }

    }
}
