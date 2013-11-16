package youngjin.Exercise.Q5;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println("waiting...");
                wait();
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println("notifyAll...");
        notifyAll();
    }
}
