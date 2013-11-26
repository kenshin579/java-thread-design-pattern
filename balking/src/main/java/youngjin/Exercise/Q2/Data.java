package youngjin.Exercise.Q2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {

        content = newContent;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        changed = true;


    }

    public void save() throws IOException {
        if (!changed) { // 가드 조건이 만족되지 않으면 바로 return
            System.out.println(Thread.currentThread().getName() + " balking...");
            return;
        }
        doSave();       // 가드 조건이 만족이 되면 저장을 처리함
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
