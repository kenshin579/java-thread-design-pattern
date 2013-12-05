package youngjin.ActiveObject;

import youngjin.ActiveObject.activeobject.ActiveObject;
import youngjin.ActiveObject.activeobject.ActiveObjectFactory;

/**
 * Producer-Consumer 패턴
 * Thread-Per-Message 패턴
 * Future 패턴
 * Worker-Thread 패턴: ActivationQueue, MakerClientThread, DisplayClientThread
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();

        // 각 쓰레드는 '문자열 작성'과 '문자열 표시' 처리를 비동기적으로 능동적 객체에게 요구함
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();

        new DisplayClientThread("Chris", activeObject).start();
    }
}
