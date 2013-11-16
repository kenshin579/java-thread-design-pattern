package youngjin.Exercise.Q4;

public class Person implements Runnable {
    int type; //1. despoit, 2.withdraw
    private String name;
    Bank bank;
    int amount;

    public Person(String name, Bank bank, int amount, int type) {
        this.name = name;
        this.bank = bank;
        this.amount = amount;
        this.type = type;
    }

    public void run() {
        System.out.println("BEGIN..." + Thread.currentThread().getName());
        while (true) {
            bank.withdraw(amount);

        }
    }
}
