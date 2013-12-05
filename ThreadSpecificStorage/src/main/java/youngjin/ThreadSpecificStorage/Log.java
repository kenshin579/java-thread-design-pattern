package youngjin.ThreadSpecificStorage;

public class Log {
    // tsLogCollection은 TSLog의 인스턴스를 각각의 쓰레드에서 보관하고 있는 락커 룸과 같이 존재함
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();
    }

    // 현재의 쓰레드를 열쇠로 사용하여 TSLog 객체를 get/set함
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();


        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
