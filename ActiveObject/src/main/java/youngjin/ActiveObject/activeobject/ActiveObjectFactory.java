package youngjin.ActiveObject.activeobject;

/**
 * 능동적인 객체는 ActiveObject 인터페이스를 구현하며 ActiveObjectFactory 클래스에서 작성함?
 */
public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();

        ActivationQueue queue = new ActivationQueue();
        SchedulerThread scheduler = new SchedulerThread(queue);

        Proxy proxy = new Proxy(scheduler, servant);
        scheduler.start();
        return proxy;
    }
}
