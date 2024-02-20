package dynamic;
import java.util.*;
/*
    5. 냅색 알고리즘 ( 돈전 교환 문제로 설명 )

    날짜 : 2024-02-20

    [설명]
    다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    각 단위의 동전은 무한정 쓸 수 있다.


    [입력]
    첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
    두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
    각 동전의 종류는 100원을 넘지 않는다.


    [출력]
    첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
    ( 출력설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다. )


    [ 냅색 알고리즘 설명 ]
    - int[] dy = new int[?] 를 만드는데, ? 는 거슬러줄 금액인 M+1 을 넣어야 한다.
    - 그리고 값에는 ? 를 거슬러 주기 위한 최소 동전 갯수가 들어가게 되는데, 예시로 dy[1] 이 된다면, 1을 거슬러 주기 위한 최소 동전 갯수가 값으로 들어간다.
    - 만약 M이 15라고 치고, 1 2 5원짜리 동전이 있다고 치면
    - 1원짜리만 계산하면 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 가 배열들의 값이 되고,
    - 2원짜리를 계산하여 배열에 더해주면, (dy[j-2] / 2) + 1 을 해서 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 이 되고 ( 단, j는 2부터 시작 ),
    - 5원짜리를 계산하여 배열에 더해주면, (dy[j-5] / 5) + 1 을 해서 1 1 2 2 1 2 2 3 3 2 3 3 4 4 3 이 된다 ( 단, j는 5부터 시작 ).
    - 그래서 마지막 15원을 거슬러주기 위한 최소 값은 3이 되는 것이다.
    - 이 때, Arrays.fill 로 먼저 Max 로 채워둔 뒤, Math.min 을 활용해주는 것이 좋다.


 */
public class Knapsack_Algorithm {
    static int n, m;
    static int[] dy;
    public static int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for ( int i=0; i<n; i++ ) {
            for ( int j=coin[i]; j<=m; j++ ) {
                dy[j] = Math.min( dy[j], dy[j-coin[i]] + 1 );
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] coin = new int[n];
        for ( int i=0; i<n; i++ ) {
            coin[i] = scan.nextInt();
        }
        m = scan.nextInt();
        dy = new int[m+1];
        System.out.println(solution(coin));
    }
}
