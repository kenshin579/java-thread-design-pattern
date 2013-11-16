package youngjin.Exercise.Q5;

public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        input.putRequest(new Request("hello"));

        for (int i = 0; i < 20; i++) {

            Request getRequestItem = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets  " + getRequestItem);

            Request putRequestItem = new Request(getRequestItem.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts  " + putRequestItem);
            output.putRequest(putRequestItem);
        }
        System.out.println(Thread.currentThread().getName() + ":END");
    }
}
