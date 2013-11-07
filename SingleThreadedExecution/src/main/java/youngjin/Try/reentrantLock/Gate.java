package youngjin.Try.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final ReentrantLock lock = new ReentrantLock();

    public void pass(String name, String address) {
        lock.lock();
        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
