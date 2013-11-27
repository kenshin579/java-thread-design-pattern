package youngjin.ThreadPerMessage;

public class Host {
    private final Helper helper = new Helper();

    // 익명 내부 클래스 안에서 메서드의 인수나 지역변수를 이용하는 경우에는 변수는 final로 선언해 두어야 함
    // - 하지 않을 경우 compile 오류생김
    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
