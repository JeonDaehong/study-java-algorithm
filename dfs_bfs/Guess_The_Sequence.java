package dfs_bfs;
import java.util.*;
/*
    8. 수열 추측하기

    날짜 : 2024-01-10

    [설명]
    가장 윗줄에 1부터 N 까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
    예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
    N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
    단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.


    [입력]
    첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
    N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.


    [출력]
    첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
    답이 존재하지 않는 경우는 입력으로 주어지지 않는다.


    [ 풀이 시간 ]
    1. 10:50 ~ 12:02


    [ 풀이 과정 ]
    1. nCr 로 수열을 만들면서, 그 수열로 역삼각형을 만들었을 때 F 가 완성되는걸 찾아야 한다.
    2. 역삼각형을 그리며 내려가게 되면, 예시로
        3           1             2            4
           (3+1)         (1+2)         (2+4)
               (3+1+1+2)       (1+2+2+4)
                   (3+1+1+1+2+2+2+4)
       이런 모양이 되는데,
       맨 끝 쪽에 있는 3과 4는 1번씩 가운데에 있는 1과 2는 3번씩 들어가서 F 를 만든다.
       그래서 1 3 3 1 모양이 되는데,
       1 은 3C0 , 3 은 3C1 , 3 은 3C2 , 1 은 3C3 이 된다. ( 실제로 계산하면 이렇다. )
       ==> nCr = n! / ( r! * (n-r)! ) 이다.
    2. 만약에 N이 5라면,
        4C0 ~ 4C4 까지이며,
        그 값은 1 4 6 4 1 이 된다.
    3. 그렇게 나온 값은 어떻게 되면, 공식이므로 그 값을 미리 배열에 저장해 놓는다. ( 1~4 라면,  1 3 3 1 을.. 1~5 라면 1 4 6 4 1 을 미리 저장한다. )
       그러므로, 콤비네이션을 구하는 공식을 미리 만들어놓는 것이 좋다.
       그걸 B[] 라는 배열이 미리 저장한다.
    4. P[] 라는 배열을 만든다. P 는 순열의 줄인 말이다.
       여기에 이제 DFS 로 계산을 하며 순열을 저장하면 된다. ( 1 2 3 4 일 수도 있고,  3 1 2 4 일 수도 있고,  2 1 4 3 일 수도 있다. )
    5. B[i] 와 P[i] 를 곱하여 Sum 에 넣는다.
    6. 그렇게 끝까지 간다. ( 누적 )
    7. Sum 의 값이 F 와 같으면 해당 P(순열) 가 정답이다.




 */
public class Guess_The_Sequence {

    static int[] B;
    static int[] P;
    static int N, F;
    static boolean[] ch;
    static boolean flag;
    static int dy[][];
    public static int combination(int n, int r) {
        if ( dy[n][r] > 0 ) return dy[n][r];
        if ( n == r || r == 0 ) return 1;
        else {
            return dy[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }

    public static void DFS(int L, int sum) {
        if ( flag ) return;
        if ( L == N ) {
            if (sum == F) {
                for (int i = 0; i < P.length; i++) {
                    System.out.print(P[i] + " ");
                }
                flag = true;
            }
            return;
        } else {
            for ( int i=1; i<=N; i++ ) {
                if ( ! ch[i] ) {
                    ch[i] = true;
                    P[L] = i;
                    DFS(L + 1, sum + (P[L] * B[L]));
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       N = scan.nextInt();
       F = scan.nextInt();
       dy = new int[N][N];
       B = new int[N];
       P = new int[N];
       ch = new boolean[N+1]; // ch 체크는 1 ~ N 까지임.
       for ( int i=0; i<N; i++ ) {
           B[i] = combination(N-1, i);
       }
       DFS(0, 0);
    }
}
