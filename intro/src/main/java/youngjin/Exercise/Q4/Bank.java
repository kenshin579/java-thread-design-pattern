package youngjin.Exercise.Q4;

public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void deposit(int m) {
        money += m;
        System.out.println("deposit: " + money);
    }

    public boolean withdraw(int m) {
        if (money >= m) {
            System.out.println(Thread.currentThread().getName() + " money = " + money);
            money -= m;
            check();
            return true;    // 인출 가능
        } else {
            return false;   // 잔고 부족
        }

    }

    private void check() {
        if (money < 0) {
            System.out.println(Thread.currentThread().getName() + " 예금잔고가 마이너스입니다! money = " + money);
        }
    }

    public String getName() {
        return name;
    }
}
