class CustomMonthException extends Exception {
    public CustomMonthException() {
        super("월은 1부터 12월까지의 값이어야 합니다.");
    }
}
public class Test2 {
    public static void monthCheck(int month) throws CustomMonthException {
        try {
            if ( month < 1 || month > 12 ) {
                throw new CustomMonthException();
            }
        } catch ( CustomMonthException e ) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            monthCheck(13);
        } catch ( CustomMonthException e ) {
            e.printStackTrace();
        }
    }
}