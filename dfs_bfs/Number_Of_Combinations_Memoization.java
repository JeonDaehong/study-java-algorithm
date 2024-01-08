package dfs_bfs;
import java.util.*;
/*
    6. 동전 교환

    날짜 : 2024-01-08

    [설명]
    재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.


    [입력]
    첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


    [출력]
    첫째 줄에 조합수를 출력합니다.


    [ 풀이 시간 ]
    1. 10:25 ~ 10:45


    [ 풀이 과정 ]
    1. nCr = n-1Cr-1 + n-1Cr 방법으로 풀어야 한다.
    2. 그러므로, 저 식을 가지고 그대로 DFS 를 만들면 된다.
    3. 이 때, 이미 방문하여 값이 있는 노드의 경우 그 값을 그대로 적용시키면 더 빠르게 구할 수 있다.
       그걸 메모이제이션이라고 한다.
       그래서 memoization 이라는 배열에 값을 저장하며 DFS 를 호출하면 된다.

    ++ DFS 에는, 이렇게 값이 0 이 될 때까지 재귀 하는 방법이 있고,
       level 를 정해서 그 level 이 정해진 갯수 값이 도달 할 때까지 재귀하는 방법이 있으며,
       그 안에서도 끝까지 중복해서 돌아야 하는 경우 for 문을 사용하고,
       그렇지 않으면 배열 등에 저장하여 중복되지 않게 하는 등의 여러가지 방법이 있다.
       이걸 상황에 따라 유동적으로 사용할 수 있어야 한다.


 */
public class Number_Of_Combinations_Memoization {
    static int[][] memoization;
    public static int DFS(int n, int r) {
        if ( memoization[n][r] > 0 ) return memoization[n][r];
        if ( n == r || r == 0 ) {
            return 1;
        } else {
            return memoization[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        memoization = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
}
