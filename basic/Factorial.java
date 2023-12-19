package basic;
import java.util.*;
/*
    3. 팩토리얼

    날짜 : 2023-12-19

    [설명]
    자연수 N이 입력되면 N! 을 구하는 프로그램을 작성하세요.
    예를 들어 5! = 5*4*3*2*1 = 120 입니다.


    [입력]
    첫 줄은 정수 N(1<=N<=100)이 주어집니다.


    [출력]
    첫 줄에 N 팩토리얼 값을 출력합니다.


    [ 풀이 시간 ]
    1. 09:20 ~ 09:22


    [ 공부해야 할 내용 ]
    1. 팩토리얼을 이해할 것.


 */
public class Factorial {

    public static int DFS(int n) {
        if ( n == 1 ) return 1;
        else {
            return n * (DFS(n - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(DFS(scan.nextInt()));
    }

}
