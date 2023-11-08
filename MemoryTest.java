


public class MemoryTest {
    static class Heap {
        private static Runtime rt = Runtime.getRuntime();
        public static void printHeap(int idx) {
            rt.gc();
            long t = rt.totalMemory();
            long f = rt.freeMemory();
            long u = t - f;
            System.out.printf("%d HEAP:%,8d bytes%n", idx, u);

        }
    }


    final static int max = 5000 *100;

    public static void main(String[] args) {
        Heap.printHeap(0);

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i<max; i++) {
            sb.append("b");
        }

        // String
        String aStr = "a";
        for ( int i=0; i<max; i++) {
            String bStr = "b";
            aStr += bStr;
        }

        Heap.printHeap(1);
        Heap.printHeap(2);
    }
}
