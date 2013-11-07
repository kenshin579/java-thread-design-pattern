package youngjin.Exercise.Q6.Answer1;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");

        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();

        // 1.우선 순위 주는 방법 (fork를 먼저)
        new EaterThread("Alice", fork, spoon).start();
        new EaterThread("Bobby", fork, spoon).start();
    }
}
