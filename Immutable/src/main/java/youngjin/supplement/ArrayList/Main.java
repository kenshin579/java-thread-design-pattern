package youngjin.supplement.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcurrentModificationException 예외가 발생함!!!
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
