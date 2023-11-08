import java.util.HashMap;
import java.util.Map;

interface aInterface {
    static int aMethod(int a) {
        return a + 10;
    };

    default int bMethod(int b) {
        return b + 20;
    }

}

public class Test {

    public static class TestClass implements aInterface {
        @Override
        public int bMethod(int b) {
            return b + 70;
        }
    }

    public static void main(String[] args) {

        // Map도 equals가 재정의 되어있기에 이렇게 확인할 수 있다.
        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();
        a.put('A', 1);
        b.put('A', 1);
        System.out.println(a.equals(b));
        System.out.println(a == b);

        // 연산자
        long l1 = 100;
        long l2 = 100L;
        long l3 = l1 + l2;
        System.out.println(l3);

        char cV = 'A';
        int iV = cV;
        System.out.println(iV);

        int pp = -65;
        char cc = (char)pp;
        System.out.println(cc);

        int a123 = 129;
        byte b123 = (byte)a123;
        System.out.println(b123);

        aInterface tClass = new TestClass();
        int ta = aInterface.aMethod(20);
        int tb = tClass.bMethod(10);
        System.out.println(ta);
        System.out.println(tb);



    }
}
