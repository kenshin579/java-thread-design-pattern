package youngjin.nosinglethreaded;

/**
 * Gate 클래스는 thread-safe하지 않다.
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    /**
     * check 메서드는 private으로 선언되어 있기 때문에 다른 쓰레드에서 실행이 안되어 synchronize로 선언할 필요가 없음
     */
    private void check() {
        // 이 메서드도 코드 자체가 쓰레드 세이프가 아니면 잘못된 디버그를 표시할 수 있음.
        // - 어떤 쓰레드가 check 메서드를 실행하고 있는 중에도 다른 쓰레드가 잇따라 pass 메서드를 실행하고
        // name, address 필드를 바꿔서 적고 있기 때문에.
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
