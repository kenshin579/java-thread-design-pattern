package youngjin.Exercise.Q4;

public class Main {
    public static void main(String[] args) {
        Bank wooribank = new Bank("Wooribank", 10000);

        Person p1 = new Person("Frank", wooribank, 10000, 2);
        Person p2 = new Person("Angela", wooribank, 10000, 2);
        Person p3 = new Person("Angela", wooribank, 10000, 2);
        Person p4 = new Person("Angela", wooribank, 10000, 2);
        Person p5 = new Person("Angela", wooribank, 10000, 2);

        Thread thread1 = new Thread(p1);
        Thread thread2 = new Thread(p2);
        Thread thread3 = new Thread(p3);
        Thread thread4 = new Thread(p4);
        Thread thread5 = new Thread(p5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
