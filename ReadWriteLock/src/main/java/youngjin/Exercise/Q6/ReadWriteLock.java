package youngjin.Exercise.Q6;

public final class ReadWriteLock {
    private int readingReaders = 0; // (a)
    private int writingWriters = 0; // (b)

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0) {
            wait();
        }
        readingReaders++;                       // (a)
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (a)
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        while (readingReaders > 0 || writingWriters > 0) {
            wait();
        }
        writingWriters++;                       // (b)
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (b)
        notifyAll();
    }
}
