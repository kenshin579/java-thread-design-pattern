package youngjin.Exercise.Q3b.content;

import java.io.DataInputStream;
import java.io.EOFException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ASyncContentImpl {
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    public Future<byte[]> getContent(final String urlstr) {
        class MakeHtmlRequest implements Callable<byte[]> {
            @Override
            public byte[] call() {
                System.out.println(Thread.currentThread().getName() + ": Getting " + urlstr);
                byte[] contentbytes = null;
                try {
                    URL url = new URL(urlstr);
                    DataInputStream in = new DataInputStream(url.openStream());
                    byte[] buffer = new byte[1];
                    int index = 0;
                    try {
                        while (true) {
                            int c = in.readUnsignedByte();
                            if (buffer.length <= index) {
                                byte[] largerbuffer = new byte[buffer.length * 2];
                                System.arraycopy(buffer, 0, largerbuffer, 0, index);
                                buffer = largerbuffer;
                                // System.out.println("Enlarging buffer to " + buffer.length);
                            }
                            buffer[index++] = (byte) c;
                            // System.out.print("Getting " + index + " bytes from " + urlstr);
                        }
                    } catch (EOFException e) {
                    } finally {
                        in.close();
                    }
                    contentbytes = new byte[index];
                    System.arraycopy(buffer, 0, contentbytes, 0, index);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return contentbytes;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }
        return executorService.submit(new MakeHtmlRequest());
    }

}
