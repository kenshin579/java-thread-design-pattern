package youngjin.Exercise.Q7;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final Mutex mutex = new Mutex();

    public void pass(String name, String address) throws InterruptedException { // synchronized
        mutex.acquire();
        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            mutex.release();
        }
    }

    public String toString() { // synchronized가 아니다
        String s = null;
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s = "No." + counter + ": " + name + ", " + address;
        } finally {
            mutex.release();
        }
        return s;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
