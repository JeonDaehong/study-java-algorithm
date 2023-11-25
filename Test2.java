class Time {

    private int hour = 0;

    Time(int hour) throws Exception {
        if ( hour < 0 || hour > 23 ) throw new Exception("hour 는 0부터 23까지만 가능합니다.");
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) throws Exception {
        if ( hour < 0 || hour > 23 ) throw new Exception("hour 는 0부터 23까지만 가능합니다.");
        this.hour = hour;
    }
}
public class Test2 {
    public static void main(String[] args) throws Exception {
        Time time = new Time(23);
        time.setHour(25); // Exception
    }
}

