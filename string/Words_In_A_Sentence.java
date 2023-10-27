package string;

import java.util.*;

/*
    3. 문장 속 단어

    날짜 : 2023-10-18

    [설명]
    한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
    문장속의 각 단어는 공백으로 구분됩니다.


    [입력]
    첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


    [출력]
    첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한


    [ 풀이 시간 ]
    1. 09:17 ~ 09:20 ( 직접풀이 : 오답 )
        -> 오답 이유 : Scanner 로 문장을 받을 때 nextLine()으로 받아야 하는데, next()로 받음.
                      Scanner 로 문장을 받을 때, next()는 공백이 생기기전까지만의 문장을 받음.
                      공백이 있는 긴 문자를 받으려면 nextLine()으로 받아야 함.

    2. 09:22 ~ 09:23 ( 직접풀이 : 정답 )


    [ 공부 해야 할 내용 ]
    1. Scanner 로 문장을 받을 때, next()는 공백이 생기기전까지만의 문장을 받음. 공백이 있는 긴 문자를 받으려면 nextLine()으로 받아야 함.
       Scanner 에 대한 것을 공부할 것.
           * next()	String을 읽음. 토큰(Token)을 기준으로 읽음.
           * nextLine()	String을 읽음. 개행(Enter)을 기준으로 읽음.
           * nextInt()	int 를 읽음.
           * nextBoolean()	boolean 을 읽음.
           * nextByte()	byte 를 읽음.
           * nextShort()	short 를 읽음.
           * nextLong()	long 을 읽음.
           * nextFloat()	float 을 읽음.
           * nextDouble()	double 을 읽음.
 */

public class Words_In_A_Sentence {

    public static String findLongWord(String str) {
        String answer = "";

        String[] tempArr = str.split(" ");
        for (String temp : tempArr) {
            if ( answer.length() < temp.length() ) {
                answer = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(findLongWord(str)); // result
    }

}
