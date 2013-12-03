package youngjin.Exercise.Q4;

public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    // �?���
    public static void println(String s) {
        getTSLog().println(s);
    }

    // �?���Ĥ���
    public static void close() {
        getTSLog().close();
    }

    // ����åɸ�ͭ�Υ?������
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // ���Υ���åɤ���θƤӽФ����Ϥ���Ƥʤ顢��������������Ͽ����
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
