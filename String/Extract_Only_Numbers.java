package String;
import java.util.*;
/*
    9. 숫자만 추출

    날짜 : 2023-10-23

    [설명]
    문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
    만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
    추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


    [입력]
    첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


    [출력]
    첫 줄에 자연수를 출력합니다.


    [ 풀이 시간 ]
    1. 10:42 ~ 10:43


    [ 공부 해야 할 내용 ]
    1. 정규식
    2. 아스키 코드가 48 ~ 57 이면 0 ~ 9 까지의 숫자이다.
    3. Character.isDigit(c) 는 char 타입의 c가 숫자인지를 확인하는 방법이다.

 */

public class Extract_Only_Numbers {

    public static int extract(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }

    // 다른 풀이 방법 ( 아스키 코드를 활용 )
    public static int extractASCII(String str) {

        int answer = 0;

        for ( char c : str.toCharArray() ) {
            if ( c >= 48 && c <= 57 ) answer = answer * 10 + ( c - 48 ); // 천천히 자릿수를 올려가기
        }
        
        return answer;
    }


    // 다른 풀이 방법 ( isDigit 를 활용 )
    public static int extractIsDigit(String str) {
        StringBuilder answer = new StringBuilder();

        for ( char c : str.toCharArray() ) {
            if ( Character.isDigit(c) ) answer.append(c);
        }

        return Integer.parseInt(answer.toString());
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(extract(str));
        System.out.println(extractASCII(str));
        System.out.println(extractIsDigit(str));
    }

}
