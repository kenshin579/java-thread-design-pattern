package youngjin.Try.COWvsSynchList;

import util.StopWatchAverage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 결과: 어느 것이 더 바쁜지는 잘 모르겠음...
 */
public class COWVsSyncListPerfTest {
    static StopWatchAverage sw1 = new StopWatchAverage("COW");
    static StopWatchAverage sw2 = new StopWatchAverage("synchronizedList");

    public void performanceTest(int runCount) {
        final List<String> cowList = new CopyOnWriteArrayList<String>();
        final List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());


        // insert the data
        String data = "abcdefghijklmnopqrstuvwxyz";

        for (int loop = 0; loop < runCount; loop++) {
            cowList.add(data + loop);
            synchronizedList.add(data + loop);
        }

        // go through each loop and test the performance
        sw1.start();
        Iterator<String> cowIter = cowList.iterator();

        while (cowIter.hasNext()) {
            String temp = cowIter.next();
        }
        sw1.stop();

        sw2.start();
        Iterator<String> synchIter = synchronizedList.iterator();
        while (synchIter.hasNext()) {
            String temp = synchIter.next();
        }
        sw2.stop();

    }

    public static void main(String[] args) {
        COWVsSyncListPerfTest test = new COWVsSyncListPerfTest();

        for (int loop = 0; loop < 100; loop++) {
            test.performanceTest(10000);
        }

        System.out.println(sw1);
        System.out.println(sw2);
    }

}
