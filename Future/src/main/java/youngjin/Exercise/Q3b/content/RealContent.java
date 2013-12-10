package youngjin.Exercise.Q3b.content;

import java.io.DataInputStream;
import java.io.EOFException;
import java.net.URL;

public class RealContent implements Content {
    byte[] contentbytes = null;

    public RealContent(String urlstr) {
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
    }

    @Override
    public byte[] getBytes() {
        return contentbytes;
    }
}
