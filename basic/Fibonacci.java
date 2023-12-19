package basic;
import java.util.*;
/*
    4. 피보나치 ( 재귀 함수 활용 / 메모이제이션 )

    날짜 : 2023-12-19

    [설명]
    피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.


    [입력]
    첫 줄은 총 항수 N(3<=N<=45)이 주어집니다.


    [출력]
    첫 줄에 피보나치 수열을 출력합니다.


    [ 풀이 시간 ]
    1. 09:31 ~ 09:55


    [ 공부해야 할 내용 ]
    1. 피보나치 수열을 이해할 것.
    2. 재귀함수로 짜는건 스택 프레임이라 배열, for문으로 구현하는 것보다 무겁고 성능도 안좋다.
    3. 메모이제이션 : 한 번 구한 계산은 다 이상 계산하지 않고 가져다 씀.
                    즉, 재귀 함수에서 fibo[3] 을 하려면 fibo[1] 과 fibo[2] 를 계산하고,
                    fibo[4] 를 하려면, fibo[3] 을 한 번 더 하고 이런 계산 과정이 있는데
                    메모이제이션 기법을 활용하면, 같은 계산은 그냥 가져다 쓸 수 있음.


 */
public class Fibonacci {

    static int[] fibo; // 메모이제이션 용 배열

    // 해당 항의 값을 return 받음 ( 피보나치의 최종 값 )
    public static int DFS(int n) {
        if ( n == 1 || n == 2 ) return 1;
        else return DFS(n-2) + DFS(n-1);
    }

    // 모든 앞의 계산을 리턴받음 ( 피보나치의 과정을 배열로 )
    // 메모이제이션 << 미리 배열안에 기록해두는 것.
    public static int DFS2(int n) {
        if ( fibo[n] > 0 ) return fibo[n];
        if ( n == 1 || n == 2 ) return fibo[n] = 1;
        else return fibo[n] = DFS2(n-2) + DFS2(n-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(DFS(n)); // 해당 항의 값을 return 받음

        fibo = new int [n+1];
        DFS2(n);
        for ( int i=1; i<n; i++ ) System.out.print(fibo[i] + " "); // 피보나치 과정을 리턴받음.

        // for ( int i=1; i<n; i++ ) System.out.print(DFS(n) + " ");  --> 이렇게 피보나치 과정을 구하는건 너무 느림. 비추천.
    }

}
