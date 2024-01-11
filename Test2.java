abstract class Greeting {
    abstract void greet();
}

public class Test2 {

    public static void main(String[] args) {
        // 익명 내부 클래스를 사용하여 Greeting 인터페이스의 인스턴스를 생성
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("안녕하세요! 익명 내부 클래스의 greet 메서드입니다.");
            }
        };

        // 익명 내부 클래스의 메서드 호출
        anonymousGreeting.greet();
    }
}