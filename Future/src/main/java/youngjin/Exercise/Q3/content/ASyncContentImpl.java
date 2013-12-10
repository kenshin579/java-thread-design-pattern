package youngjin.Exercise.Q3.content;

import java.util.concurrent.Callable;

public class ASyncContentImpl {
    public Content getContent(final String urlstr) {
        System.out.println(Thread.currentThread().getName() + ": Getting " + urlstr);

        FutureContent future = new FutureContent(
                new Callable<RealContent>() {
                    public RealContent call() {
                        return new RealContent(urlstr);
                    }
                }
        );

        new Thread(future).start();

        return future;
    }

}
