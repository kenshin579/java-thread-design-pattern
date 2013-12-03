package youngjin.ThreadSpecificStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    private static PrintWriter writer = null;

    // writer�ե�����ɤν��
    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // �?���
    public static void println(String s) {
        writer.println(s);
    }

    // �?���Ĥ���
    public static void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
