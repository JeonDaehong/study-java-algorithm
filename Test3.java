import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Test3 {
    static final Map<String, Integer> map = new ConcurrentHashMap<>() {
    };
    static {
        map.put("stock", 100);
    }

    public static void main(String[] args) {
        IntStream.range(0, 50)
                .parallel() // 멀티쓰레드 구동 (제거 불가)
                .forEach(n -> map.compute("stock", (key, value) -> value - getOrderQuantity()));
        System.out.println(map.get("stock")); // 출력값 90 내외 찍힘
        // [Q] 출력값 0을 보장해주려면?
    }

    // 100ms 후 2 리턴
    public static int getOrderQuantity() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
