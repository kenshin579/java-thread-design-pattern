package youngjin.supplement;

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData�Υ��󥹥��󥹤���
        //     �ʥ��󥹥ȥ饯����Callable<RealData>���Ϥ���
        FutureData future = new FutureData(
                new Callable<RealData>() {
                    public RealData call() {
                        return new RealData(count, c);
                    }
                }
        );

        // (2) RealData���뤿��ο���������åɤ�ư����
        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData�Υ��󥹥��󥹤�����ͤȤ���
        return future;
    }
}
