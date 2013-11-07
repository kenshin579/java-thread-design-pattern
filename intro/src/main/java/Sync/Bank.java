package Sync;

public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            return true;    // 인출 가능
        } else {
            return false;   // 잔고 부족
        }
    }

    public String getName() {
        return name;
    }
}
