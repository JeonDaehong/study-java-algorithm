import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();
        a.put('A', 1);
        b.put('A', 1);
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
