package youngjin.Exercise.Q4;

public class Table {
    private final String[] buffer;
    private int head;
    private int tail;
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public void clear() {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = "";
        }
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) { // 가드 조건
            System.out.println(Thread.currentThread().getName() + " put - BEFORE waiting");
            wait();
            System.out.println(Thread.currentThread().getName() + " put - AFTER waiting");
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) { // 가드 조건
            System.out.println(Thread.currentThread().getName() + " take - BEFORE waiting");
            wait();
            System.out.println(Thread.currentThread().getName() + " take - AFTER waiting");
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
