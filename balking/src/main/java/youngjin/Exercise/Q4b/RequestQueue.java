//package youngjin.Exercise.Q4b;
//
//import java.util.concurrent.BlockingQueue;
//
//public class RequestQueue {
//    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
//
//    public Request getRequest() {
//        Request req = null;
//        try {
//            req = queue.take();
//        } catch (InterruptedException e) {
//        }
//        return req;
//    }
//
//    public void putRequest(Request request) {
//        try {
//            queue.put(request);
//        } catch (InterruptedException e) {
//        }
//    }
//}
