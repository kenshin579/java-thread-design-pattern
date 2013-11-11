package youngjin.Try.StringVsStringBuffer;

import util.StopWatchAverage;

public class StringVsStringBufferPerfTest {
    static StopWatchAverage sw1 = new StopWatchAverage("String");
    static StopWatchAverage sw2 = new StopWatchAverage("StringBuffer");

    public void performanceTest(int runCount) {

    }

    public static void main(String[] args) {
        StringVsStringBufferPerfTest test = new StringVsStringBufferPerfTest();

        for (int loop = 0; loop < 100; loop++) {
            test.performanceTest(10000);
        }

        System.out.println(sw1);
        System.out.println(sw2);
    }

}
