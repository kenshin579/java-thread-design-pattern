package youngjin.Exercise.Q4;

public final class UserInfo {
    //    private final StringBuffer info;
    private final String info;

    public UserInfo(String name, String address) {
//        this.info = new StringBuffer("<info name=\"" + name + "\" address=\"" + address + "\" />");
        this.info = new String("<info name=\"" + name + "\" address=\"" + address + "\" />");
    }

    //    public StringBuffer getInfo() {
    public String getInfo() {
        return info;
    }

    public String toString() {
        return "[ UserInfo: " + info + " ]";
    }
}
