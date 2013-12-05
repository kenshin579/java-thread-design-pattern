package youngjin.supplement;

import youngjin.supplement.activeobject.ActiveObject;
import youngjin.supplement.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        try {
            new MakerClientThread("Alice", activeObject).start();
            new MakerClientThread("Bobby", activeObject).start();

            new DisplayClientThread("Chris", activeObject).start();
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "...stopped");

        } finally {
            System.out.println("*** shutdown ***");
            activeObject.shutdown();
        }
    }
}
