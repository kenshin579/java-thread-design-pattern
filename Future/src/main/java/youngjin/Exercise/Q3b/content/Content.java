package youngjin.Exercise.Q3b.content;

import java.util.concurrent.Future;

public interface Content {
    public abstract Future<byte[]> getBytes();
}
