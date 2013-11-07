package Exercise.Q3;

public class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    /**
     * looping이 너무 짧게 끝나서 ****, ++++ 순으로 실행됨
     */
    public void run() {
//        for (int i = 0; i < 1000; i++) {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }
}
