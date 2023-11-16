package stack_queue;
import java.util.*;
/*
    4. 후위식 연산 (PostFix)

    날짜 : 2023-11-16

    [설명]
    후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
    만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


    [입력]
    첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
    식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.


    [출력]
    연산한 결과를 출력합니다.


    [ 풀이 시간 ]
    1. 11:35 ~ 12:00


    [ 공부해야 할 내용 ]
    1. 처음부터 char 형에 '1', '2'로 들어가 있는걸 int로 바꾸거나 연산을 해주면 ASCII 코드로 변환되어 49, 50이 반환된다.
       그래서 -48을 해줘야지만 원래 숫자가 나온다. ( 참고로 '0' 은 48이다. )
       그러나 원래 int에 담겨있건걸, char로 넘기면 그 숫자 그대로가 ASCII코드가 넘어가므로, 1을 넘기면 ASCII 코드 1이 된다.
       그래서 제어 문자 SOH라는게 들어가고, 다시 int로 넘겼으므로 1이 출력된다.

    2. 전위, 중위, 후위식 계산하는 방법을 공부해라.

    3. Stack은 FIFO이므로 후위식 계산에서는 먼저 pop된게 rt고, 다음에 pop된게 lt라서,
       lt (연산) rt를 해줘야 한다.


 */
public class Postfix {
    public static int postfix(String str) {
        Stack<Integer> stack = new Stack<>();
        for ( char c : str.toCharArray() ) {
            if ( Character.isDigit(c) ) {
                stack.push((int)c -48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if ( c == '+' ) {
                    stack.push(lt + rt);
                } else if ( c == '-' ) {
                    stack.push(lt - rt);
                } else if ( c == '*' ) {
                    stack.push(lt * rt);
                } else if ( c == '/' ) {
                    stack.push(lt / rt);
                }
            }
        }
        return stack.get(0);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(postfix(str));
    }
}
