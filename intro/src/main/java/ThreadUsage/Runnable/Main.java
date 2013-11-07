package ThreadUsage.Runnable;

/**
 * 질문: interface를 생성자에게 넘겨주면... 어떻게 사용될 수 있나?
 * - strategy 패턴처럼 내가 원하는 다양한 구현체를 실행할 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();

//        Runnable r1 = new Printer("Good!");
//        Thread t1 = new Thread(r1);
//        t1.start();
    }
}
