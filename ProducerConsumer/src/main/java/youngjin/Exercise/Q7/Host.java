package youngjin.Exercise.Q7;

public class Host {
    public static void execute(int count) {
        for (int i = 0; i < count; i++) {
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        // �ʲ��ϡ�
        // �֥���󥻥��Բ�ǽ�ʽŤ�����פ�����
        // ����10�ôֲ��롼�ס�
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {
            // busy loop
        }
        System.out.println("doHeavyJob END");
    }
}
