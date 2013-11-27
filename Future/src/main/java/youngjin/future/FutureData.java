package youngjin.Future;

/**
 * RealData의 교환권이 되는 클래스...
 */
public class FutureData implements Data {
    private RealData realdata = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        if (ready) {
            return;     // balk
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    /**
     * getContent를 비동기식으로 구현하는 것도 가능함
     * - balking 패턴을 사용하면 됨 (더 구체적으로는??).
     *
     * @return
     */
    public synchronized String getContent() {
        while (!ready) { // 가드 조건
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realdata.getContent();
    }
}
