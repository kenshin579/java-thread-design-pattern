package youngjin.Exercise.Q4;

public class Main {
    public static void main(String[] args) {
        Database<Integer, String> database = new Database<Integer, String>();

        new ReaderThread(database).start();
        new ReaderThread(database).start();
        new ReaderThread(database).start();
        new ReaderThread(database).start();

        new WriterThread(database).start();
        new WriterThread(database).start();
    }
}
