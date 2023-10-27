package string;
import java.util.Scanner;
/*
    11. 문자열 압축

    날짜 : 2023-10-23

    [설명]
    알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
    문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
    단 반복횟수가 1인 경우 생략합니다


    [입력]
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


    [출력]
    첫 줄에 압축된 문자열을 출력한다.


    [ 풀이 시간 ]
    1. 13:07 ~ 13:13

 */
public class String_Compression {
    public static String compression(String str) {

        StringBuilder answer = new StringBuilder();

        char x = ' ';
        int i = 1;
        for ( int k = 0; k < str.length(); k++ ) {
            char c = str.charAt(k);
            if ( x == c ) {
                i ++;
            } else {
                if ( i != 1 ) {
                    answer.append(i);
                }
                answer.append(c);
                x = c;
                i = 1;
            }
            if ( k == str.length() -1 && i > 1 ) {
                answer.append(i);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(compression(str));
    }
}
