package youngjin.Exercise.Q5;

/**
 * writingWriters의 값은 0 또는 1입니다. 2이상되는 경우는 없음
 */
public final class ReadWriteLock {
    private int readingReaders = 0; // (A) 실제로 읽고 있는 중인 쓰레드의 수
    private int waitingWriters = 0; // (B) 쓰기를 기다리고 있는 쓰레드의 수
    private int writingWriters = 0; // (C) 실제로 쓰고 있는 중인 쓰레드의 수
    private boolean preferWriter = true; // 쓰는 것을 우선하면 true, 아니면 읽기가 우선

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A) 실제로 읽고 있는 쓰레드의 수를 한 개 늘린다.
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A) 실제로 읽고 있는 쓰레드의 수를 한개 줄인다.
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한개 늘린다.
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한개 줄인다.
        }
        writingWriters++;                       // (C) 실제로 쓰고 있는 쓰레드의 수를 한개 늘린다.
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C) 실제로 쓰고 있는 쓰레드의 수를 한개 줄인다.
        preferWriter = false;
        notifyAll();
    }
}
