package basic;
import java.util.*;
/*
    2. 재귀 함수 ( 이진수 출력하기 )

    날짜 : 2023-12-18

    [설명]
    10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야 합니다.


    [입력]
    첫 줄은 정수 N(3<=N<=1,000)이 주어집니다.


    [출력]
    첫 줄에 이진수를 출력하세요.


    [ 풀이 시간 ]
    1. 09:45 ~ 09:48


    [ 공부해야 할 내용 ]
    1. 10진수 --> 2진수 구하는 방법을 이해할 것.


 */
public class Binary_Recursive_Functions {

    public static void DFS(int n) {
        if ( n == 0 ) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DFS(scan.nextInt());
    }

}
