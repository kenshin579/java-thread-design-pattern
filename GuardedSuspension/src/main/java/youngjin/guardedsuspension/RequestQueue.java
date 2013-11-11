package youngjin.guardedsuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * synchronized는 무엇을 지키고 있는가?
 * - queue 필드
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>(); // 왜 final로 했나?

    // 가드 조건이 충족이 되면 request는 remove하고 그렇지 않을 경우에는 wait()을 하게 됨
    public synchronized Request getRequest() {
        while (queue.peek() == null) {  // 가드 조건
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }

    //
    public synchronized void putRequest(Request request) {
        queue.offer(request); //insert
        notifyAll();
    }
}
