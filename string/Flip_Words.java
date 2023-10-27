package string;
import java.util.*;
/*
    4. 단어 뒤집기

    날짜 : 2023-10-18

    [설명]
    N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


    [입력]
    첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
    두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


    [출력]
    N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


    [ 풀이 시간 ]
    10:45 ~ 10:54


    [ 공부 해야 할 내용 ]
    1. String tmpString = new StringBuilder(str).reverse().toString(); 을 활용해서 문자열을 뒤집을 수 있다.
        -> Java에서 String은 불변(immutable)한 문자열을 처리하기 위한 클래스입니다.
           즉, String 객체가 생성되면 그 값은 변경되지 않습니다. “새로운 객체”로 추가 및 변경이 됩니다.
        -> Java에서 StringBuffer는 가변(mutable)한 문자열을 처리하기 위한 클래스입니다.
           즉, 새로운 문자열을 추가하거나 변경하게 되면 “기존의 객체”로 추가 및 변경이 됩니다.
       -> Java에서 StringBuilder는 가변(mutable)한 문자열을 처리하기 위한 클래스입니다.
            - StringBuffer와 마찬가지로 새로운 문자열을 추가하거나 변경하게 되면 “기존의 객체”로 추가 및 변경이 됩니다.
            - StringBuffer와 다르게 멀티쓰레드 환경에서 안정적이지 않으며, StringBuilder는 싱글쓰레드 환경에서 StringBuffer보다 더 빠른 성능을 가집니다.
    2. char[] cArr = new char[5];  ->  String str = String.valueOf(cArr); 이렇게 문자 배열을 문자열로 만들 수 있다.

 */

public class Flip_Words {

    public static List<String> flipWords(List<String> strList) {

        List<String> answer = new ArrayList<String>();

        for (String str : strList) {
            String tempString = "";
            for (int i=str.length()-1; i>=0; i--) {
                tempString += str.charAt(i);
            }
            answer.add(tempString);
        }

        return answer;
    }

    // new StringBuilder(str).reverse().toString(); 을 활용해서 뒤집을 수도 있다.
    public static List<String> flipWords2(List<String> strList) {

        List<String> answer = new ArrayList<String>();

        for (String str : strList) {
            String tmp = new StringBuilder(str).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> strList = new ArrayList<String>();
        int count = scan.nextInt();
        for (int i=0; i<count; i++) {
            strList.add(scan.next());
        }

        strList = flipWords2(strList);

        for ( String str : strList ) {
            System.out.println(str);
        }

    }
}
