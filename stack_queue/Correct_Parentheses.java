package stack_queue;
import java.util.*;
/*
    1. 올바른 괄호

    날짜 : 2023-11-14

    [설명]
    괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
    (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


    [입력]
    첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


    [출력]
    첫 번째 줄에 YES, NO를 출력한다.


    [ 풀이 시간 ]
    1. 11:20 ~ 11:22


    [ 공부해야 할 내용 ]
    1. Stack 의 구조와, Stack 의 메서드를 공부할 것.
    - init(): 스택을 초기화한다.
    - isEmpty(): 스택이 비어있으면 true를 아니면 false를 반환한다.
    - isFull(): 스택이 가득 차 있으면 true를 아니면 false를 반환한다.
    - size(): 스택 내의 모든 요소들의 개수를 반환한다.
    - push(x): 스택 맨 위에 있는 요소를 삭제하고 반환한다.
    - pop(): 스택 맨 위에 있는 요소를 삭제하고 반환한다.
    - peek(): 스택 맨 위에 있는 요소를 삭제하지 않고 반환한다.


 */
public class Correct_Parentheses {
    public static String solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for ( char c : str.toCharArray() ) {
            if ( c == '(') {
                stack.push(1);
            } else if ( c == ')') {
                if ( stack.isEmpty() ) return "NO";
                stack.pop();
            }
        }
        if ( !stack.isEmpty() ) return "NO";
        return "YES";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(solution(str));
    }
}
