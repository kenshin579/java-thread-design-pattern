package youngjin.Future;

/**
 * Future 패턴은 시간이 걸리는 처리를 포함하고 있는 보통의 클래스에 대하여 교환권을 만들어 주고, 멀티 쓰레드화하여 수행 능력을 높이는 패턴임
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) FutureData 인스턴스 생성함
        final FutureData future = new FutureData();

        // (2) ReadData의 인스턴스를 만들기 위한 새로운 쓰레드를 기동함
        new Thread() {
            public void run() {
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) FutureData의 인스턴스를 반환 값으로 한다
        return future;
    }
}
