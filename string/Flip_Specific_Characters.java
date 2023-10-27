package string;
import java.util.*;

/*
    5. 특정 문자 뒤집기

    날짜 : 2023-10-18

    [설명]
    영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


    [입력]
    첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


    [출력]
    첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


    [ 풀이 시간 ]
    10:00 ~ 10:21


    [ 공부 해야 할 내용 ]
    1. Character.isAlphabetic(c) 를 하면, c가 영어인지 아닌지를 알 수 있음.

 */

public class Flip_Specific_Characters {

    public static String flip(String str) {
        String answer = "";

        char[] cArr = str.toCharArray();
        int cIdxS = 0, cIdxE = (cArr.length - 1);

        while (cIdxS <= cIdxE) {
            if ( !Character.isAlphabetic(cArr[cIdxS]) ) {
                cIdxS ++;
            } else if ( !Character.isAlphabetic(cArr[cIdxE])) {
                cIdxE --;
            } else {
                char tmpC = cArr[cIdxS];
                cArr[cIdxS] = cArr[cIdxE];
                cArr[cIdxE] = tmpC;
                cIdxS ++;
                cIdxE --;
            }
        }

        answer = String.valueOf(cArr);

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(flip(str));
    }

}
