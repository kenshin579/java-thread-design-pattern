package youngjin.Exercise.Q3.content;

public class Retriever {
    public static Content retrieve(String urlstr) {
//        return new SyncContentImpl(urlstr);
        return new ASyncContentImpl().getContent(urlstr);
    }
}
