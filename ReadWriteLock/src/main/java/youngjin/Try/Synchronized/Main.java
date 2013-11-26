package youngjin.Try.Synchronized;

import util.StopWatchAverage;

/**
 * 성능 비교는 어떻게 할 수 있나?
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(10);

//        new ReaderThread(data).start();
//        new ReaderThread(data).start();
//        new ReaderThread(data).start();
//        new ReaderThread(data).start();
//        new ReaderThread(data).start();
//        new ReaderThread(data).start();
//
//        new WriterThread(data, "ABCDEFGHIJKLMNOPQTSTUVWXYZ").start();
//        new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();

        ReaderThread r1 = new ReaderThread(data);
        ReaderThread r2 = new ReaderThread(data);
        ReaderThread r3 = new ReaderThread(data);
        ReaderThread r4 = new ReaderThread(data);
        ReaderThread r5 = new ReaderThread(data);
        ReaderThread r6 = new ReaderThread(data);

        WriterThread w1 = new WriterThread(data, "ABCDEFGHIJKLMNOPQTSTUVWXYZ");
        WriterThread w2 = new WriterThread(data, "abcdefghijklmnopqrstuvwxyz");

        StopWatchAverage sw1 = new StopWatchAverage("synchronized");
        StopWatchAverage sw2 = new StopWatchAverage("lock");

        sw1.start();
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();

        w1.start();
        w2.start();

        r1.join();
        r2.join();
        r3.join();
        r4.join();
        r5.join();
        r6.join();

        w1.join();
        w2.join();

        sw1.stop();

        //
        youngjin.ReadWriteLock.Data data2 = new youngjin.ReadWriteLock.Data(10);
        youngjin.ReadWriteLock.ReaderThread ra1 = new youngjin.ReadWriteLock.ReaderThread(data2);
        youngjin.ReadWriteLock.ReaderThread ra2 = new youngjin.ReadWriteLock.ReaderThread(data2);
        youngjin.ReadWriteLock.ReaderThread ra3 = new youngjin.ReadWriteLock.ReaderThread(data2);
        youngjin.ReadWriteLock.ReaderThread ra4 = new youngjin.ReadWriteLock.ReaderThread(data2);
        youngjin.ReadWriteLock.ReaderThread ra5 = new youngjin.ReadWriteLock.ReaderThread(data2);
        youngjin.ReadWriteLock.ReaderThread ra6 = new youngjin.ReadWriteLock.ReaderThread(data2);

        youngjin.ReadWriteLock.WriterThread wa1 = new youngjin.ReadWriteLock.WriterThread(data2, "ABCDEFGHIJKLMNOPQTSTUVWXYZ");
        youngjin.ReadWriteLock.WriterThread wa2 = new youngjin.ReadWriteLock.WriterThread(data2, "abcdefghijklmnopqrstuvwxyz");

        sw2.start();
        ra1.start();
        ra2.start();
        ra3.start();
        ra4.start();
        ra5.start();
        ra6.start();

        wa1.start();
        wa2.start();

        ra1.join();
        ra2.join();
        ra3.join();
        ra4.join();
        ra5.join();
        ra6.join();

        wa1.join();
        wa2.join();

        sw2.stop();

        System.out.println(sw1);
        System.out.println(sw2);

    }
}
