package youngjin.Exercise.Q1;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    /**
     * critical section을 길게 만들면 에러 검출 가능성을 높일 수 있다고 함!!!
     */
    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        // 1.방법: Thread.sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 2.방법: yield() 메서드로 잠깐 다른 쓰레드에게 실행을 양도하도록 함
//        Thread.yield();
        this.address = address;
        check();
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
