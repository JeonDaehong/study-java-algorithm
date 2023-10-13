package String;

import java.util.*;

/**
    2. 대소문자 변환

    날짜 : 2023-10-13


    [ 설명 ]
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.


    [ 입력 ]
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.


    [ 출력 ]
    첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.


    [ 풀이 시간 ]
    11:00 ~ 11:06 ( 직접풀이 : 정답 )

    [ 공부 해야 할 내용 ]
    1. 해당 문자가 대문자인지 소문자인지 확인하는 방법 : Character.isUpperCase(c); / Character.isLowerCase(c);
    2. 아스키 코드로도 가능하다.
      -> 대문자 = 65 ~ 90    ex) if ( c >= 65 && c <= 90 )
      -> 소문자 : 97 ~ 122   ex) if ( c >= 97 && c <= 122 )
      -> 소문자에서 32를 빼면, 해당 문자의 대문자가 되고,
         대문자에서 32를 더하면, 해당 문자의 소문자가 된다.

 */

public class Change_Case {

    // 일반 풀이
    public static String normalChange(String str) {

        String answer = "";

        for ( char c : str.toCharArray() ) {
            if ( Character.isUpperCase(c) ) answer += Character.toLowerCase(c);
            else answer += Character.toUpperCase(c);
        }

        return answer;

    }

    // 아스키 코드를 활용한 풀이
    public static String ASCII_Change(String str) {

        String answer = "";

        for (char c : str.toCharArray()) {
            if ( c >= 65 && c <= 90  ) answer += (char)(c + 32);
            else if ( c >= 97 && c <= 122 ) answer += (char)(c - 32);
        }

        return answer;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(normalChange(str)); // 일반 풀이
        System.out.println(ASCII_Change(str)); // 아스키 코드를 활용한 풀이
    }

}
