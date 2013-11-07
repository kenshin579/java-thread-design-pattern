package youngjin.Exercise.Q5.MyVersion;

public class SecurityGate {
    private int counter = 0;
//    private volatile int counter = 0; // volatile로 선언해도 동기화는 제대로 안됨 (why?)

    public void enter() {
        counter++;
    }

    public void exit() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

}
