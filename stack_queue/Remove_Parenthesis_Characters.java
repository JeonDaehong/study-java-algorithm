package stack_queue;
import java.util.*;
/*
    2. 괄호 문자 제거

    날짜 : 2023-11-16

    [설명]
    입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.


    [입력]
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


    [출력]
    남은 문자만 출력한다.


    [ 풀이 시간 ]
    1. 09:10 ~ 09:25


 */

public class Remove_Parenthesis_Characters {

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for ( char c : str.toCharArray() ) {
            stack.push(c);
            if ( c == ')' ) {
                while(true) {
                    char stackC = stack.pop();
                    if ( stack.isEmpty() || stackC == '(' ) break;
                }
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            strBuilder.append(stack.pop());
        }

        return strBuilder.reverse().toString();
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(solution(str));
    }

}
