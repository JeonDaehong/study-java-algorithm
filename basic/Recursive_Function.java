package basic;
import java.util.*;
/*
    1. 재귀 함수

    날짜 : 2023-12-18

    [설명]
    자연수 N이 입력되면 재귀함수를 이용하여 1~N까지 출력하는 프로그램을 작성하세요


    [입력]
    첫 줄은 정수 N(3<=N<=10)이 주어집니다.


    [출력]
    첫 줄에 출력합니다.


    [ 풀이 시간 ]
    1. 09:25 ~ 09:30


    [ 공부해야 할 내용 ]
    1. 재귀 함수에 대하여 완벽히 이해합니다.
    2. 재귀함수는 "스택"을 사용하여 계산한다. "스택프레임"이라고 한다. 그 개념을 알아야 한다.
        --> DFS(n) 이 생성되면, DFS(n)에 대한 매개변수 지역변수 복귀주소가 들어있는게 스택에 생성된다.
        --> DFS(3) 을 하면, DFS(3) DFS(2) DFS(1) DFS(0) 이 스택에 순차적으로 쌓이게 된다.
        --> DFS(3) 을 하면, DFS(3-1) 을 호출하게 되는데, 그럼 그 아래에 있는 System.out.print(n + " "); 은 잠시 대기 상태가 된다.
        --> 그랫 DFS(0) 이 될때까지 System.out.print(n + " "); 은 대기하다가, DFS(0) 부터 차례로 (스택이니까) 완료 시키며 pop(); 한다.
        --> 그래서 아래 코드처럼 작성하면, System.out.print(n + " "); 이 역순으로 출력되는 것이다. ( 스택 상단부터 내려오듯 실행되니까 )
        --> 그래서 DFS(n-1) 보다 앞에 System.out.print(n + " "); 이 있으면, n n-1 n-2 n-3 ~ n-.. 이렇게 출력이 되고,
            DFS(n-1) 보다 뒤에 System.out.print(n + " "); 가 있으면, n-.. ~ n-2 n-1 n 이렇게 출력되는 것이다.
        --> 스택프레임은 스택이니 재귀호출 한 아래의 코드는 peek (상단) 부터 pop 되면서 호출된다고 생각하면 된다.


 */
public class Recursive_Function {

    public static void DFS(int n) {
        if ( n == 0 ) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DFS(scan.nextInt());
    }

}
