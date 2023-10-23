package String;
import java.util.*;

/*
    8. 유효한 팰린드롬

    날짜 : 2023-10-23

    [설명]
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
    문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
    알파벳 이외의 문자들의 무시합니다.


    [입력]
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


    [출력]
    첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.


    [ 풀이 시간 ]
    1. 09:50 ~ 10:20 ( 풀이 실패 : 특수문자를 어떻게 해야할지 해법을 찾지 못함. )
    2. 10:20 ~ 10:23 ( 강의를 듣고 다시 풀어봄 )



    [ 공부 해야 할 내용 ]
    1. 정규식 공부

    2. replace(a, b); 와 replaceAll(a, b); 의 차이를 알아야 한다.
        --> replace(a, b); 는 a와 b에 문자열을 넣어서 딱 그 문자열에 부합한 a를 b로 치환해준다.
        --> 그러나 replaceAll(a, b); 는 a에 정규식이 들어가므로, 정규식 a에 맞는 값을 b로 치환해준다.

 */

public class Valid_Palindrome {

    public static String validationCheck(String str) {

        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // replaceAll 의 정규식에 A-Z가 들어갔으므로, toUpperCase를 해준다.
        // System.out.println(str); // 체크용
        String tmp = new StringBuilder(str).reverse().toString();
        if ( !tmp.equals(str) ) return "NO";

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine(); // 여러 단어를 입력해야 하므로
        System.out.println(validationCheck(str));
    }

}
