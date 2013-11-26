package youngjin.Exercise.Q4a;


import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {

            try {
                Thread.sleep(2000);
                throw new LivenessException("가드 조건 실패");
//                wait();
            } catch (InterruptedException e) {
            }
        }

        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
