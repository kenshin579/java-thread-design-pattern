package youngjin.Exercise.Q2a;

import youngjin.Exercise.Q2a.activeobject.ActiveObject;
import youngjin.Exercise.Q2a.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new AddClientThread("Diana", activeObject).start();
    }
}
