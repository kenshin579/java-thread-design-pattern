package youngjin.Exercise.Q5.Answer;

public class SecurityGate {
    private int counter = 0;

    public void enter() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter + 1;
    }

    public void exit() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }

//    public void enter() {
//        counter++;
//    }
//
//    public void exit() {
//        counter--;
//    }

    public int getCounter() {
        return counter;
    }

}
