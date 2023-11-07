public class test {
    public static void main(String[] args) {
        int i = 0;
        StringBuilder a = new StringBuilder();
        String b = "";
        String c = "";
        while ( i < 100000 ) {
            b = String.valueOf(i);
            c = String.valueOf(i);
            a.append(b).append(c);
            i++;
        }
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}
