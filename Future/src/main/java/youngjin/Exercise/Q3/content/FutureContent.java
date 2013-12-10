package youngjin.Exercise.Q3.content;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureContent extends FutureTask<RealContent> implements Content {
    public FutureContent(Callable<RealContent> callable) {
        super(callable);
    }

    @Override
    public byte[] getBytes() {
        byte[] contentBytes = null;
        try {
            contentBytes = get().getBytes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return contentBytes;
    }
}
