package youngjin.Exercise.Q3;

import youngjin.ThreadPerMessage.Host;

public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");

        youngjin.ThreadPerMessage.Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');

        System.out.println("main END");
    }
}
