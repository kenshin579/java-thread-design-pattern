package youngjin.nonVolatileVsVolatile;

/**
 * volatile 필드에 대한 읽고 쓰기는 키시되지 않습니다.
 * volatile 필드에 읽고 쓰기를 하기 전후에는 reorder가 일어나지 않는다.
 */
class Runner extends Thread {
    //    private boolean quit = false; // while이 무한 루프가 될 가능성이 있어 Done 메시지가 표지 되지 않을 가능성이 있음
    private volatile boolean quit = false; // while이 무한 루프가 될 가능성이 없다.

    public void run() {
        while (!quit) {
            // ...
        }
        System.out.println("Done");
    }

    public void shutdown() {
        quit = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        runner.shutdown();
    }
}
