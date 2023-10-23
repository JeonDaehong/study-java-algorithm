package String;
import java.util.*;

/*
    7. 회문 문자열

    날짜 : 2023-10-18

    [설명]
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
    문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 대소문자를 구분하지 않습니다.


    [입력]
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


    [출력]
    첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


    [ 풀이 시간 ]
    12:10 ~ 12:15


    [ 공부 해야 할 내용 ]
    1. String tmp = new StringBuilder(str).reverse().toString(); 이렇게 StringBuilder 를 활용하여 뒤집은 String 을 바로 구할 수 있음.
    2. String 끼리 비교할 때 str.equalsIgnoreCase(tmp) 이렇게 비교하면 대소문자를 구분하지 않고 비교할 수 있음.
      --> equals == 대소문자 구분하여 비교
      --> equalsIgnoreCase == 대소문자 구분하지 않고 비교


 */

public class Palindrome_String {

    public static String palindromeString(String str) {

        str = str.toLowerCase();
        char[] cArr = str.toCharArray();
        int cS = 0, cE = cArr.length - 1;

        while ( cS <= cE ) {
            if ( cArr[cS] != cArr[cE] ) {
                return "NO";
            }
            cS ++;
            cE --;
        }

        return "YES";
    }

    // StringBuilder.reverse().toString(); 을 활용한 방법
    public static String palindromeString2(String str) {

        String tmp = new StringBuilder(str).reverse().toString();
        if ( !str.equalsIgnoreCase(tmp) ) return "NO";

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(palindromeString(str));
        System.out.println(palindromeString2(str));
    }

}
