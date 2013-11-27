package youngjin.Future;

/**
 * 실제 데이터를 표현한 클래스... 다소 시간이 걸리는 데이터
 */
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println("        making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("        making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }

    public String getContent() {
        return content;
    }
}
