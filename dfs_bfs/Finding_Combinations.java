package dfs_bfs;
import java.util.*;
/*
    9. 조합 구하기

    날짜 : 2024-01-11

    [설명]
    1 ~ N 번호가 적힌 구슬이 있습니다. 이 중 M 개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번쨰 줄에 자연수 N(3<=N<=10) 과 M(2<=M<=N) 이 주어집니다.


    [출력]
    첫 번쨰 줄에 결과를 출력합니다.
    출력 순서는 사전 순으로 오름차순으로 출력합니다.


    [ 풀이 시간 ]
    1. 09:57 ~ 10:10


    [ 풀이 과정 ]
    1. 일반적인 중복순열 구하기와 로직은 비슷하다. 그러나 다른 점이 있다면, 여기서는 중복이 안된다는 것이다.
    2. for 문과 ch 배열을 활용하여 같은 숫자가 나오지 않게 한다.
    3. DFS 에 S 라는 int 값을 넘겨주어, for 문을 그 숫자부터 돌게 만듦으로 왼쪽 수가 오른쪽 수보다 무조건 작게 유지 할 수 있다.
    4. 이러면 자연스럽게 앞에 나왔던 숫자를 뒤집어도 중복이 되는 수는 만들지 않을 수 있다.
    5. 이 때 주의해야 하는 것은 처음에 DFS 에 값을 넣을 때, Level 은 그대로 0 이지만, S 는 1부터 넣어주어야 한다.
        - 만약 0 ~ 4 로 구하는거라면 S 도 0이면 된다.
        - 5 ~ 10까지 구하는거라면 S 는 5부터 시작이다.

 */
public class Finding_Combinations {
    static int N, M;
    static boolean[] ch;
    static int[] answer;
    public static void DFS(int L, int S) {
        if ( L == M ) {
            for ( int i = 0; i < M; i ++ ) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for ( int i = S; i <= N; i ++ ) {
                if ( ! ch[i] ) {
                    ch[i] = true;
                    answer[L] = i;
                    DFS(L+1, i+1);
                    ch[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        ch = new boolean[N+1];
        answer = new int[M];
        DFS(0, 1);
    }
}
