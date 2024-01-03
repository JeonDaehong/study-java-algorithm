package dfs_bfs;
import java.util.*;
/*
    3. 최대 점수 구하기

    날짜 : 2024-01-03

    [설명]
    이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
    각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
    제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
    (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)


    [입력]
    첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
    두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.


    [출력]
    첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.


    [ 풀이 시간 ]
    1. 09:42 ~ 09:55


    [ 풀이 과정 ]
    - 부분집합 구하는 스타일과 동일하다.
    1. nArr[0] 에는 점수를, nArr[1] 에는 그 문제를 푸는 시간을 담는다.
    2. M 은 시간인데, nArr[1] 의 합이 M 을 넘어가서는 안된다.
    3. 모든 경우를 다 돌며 가장 큰 점수의 합을 찾아야 한다.
    4. sumTime 이 M 보다 크지 않으면서, level 이 N 에 도달하면 answer 와 sumScore 를 비교하여 더 큰 값을 answer 에게 주어야 한다.
    5. 이차원 배열을 활용하거나, 두 개의 배열을 활용하면 된다.


 */
public class Maximum_Score {

    static int N, M;
    static int answer = Integer.MIN_VALUE;

    public static void DFS( int level, int sumScore, int sumTime, int[][] nArr ) {
        if ( sumTime > M ) return;
        if ( level == N ) {
            answer = Math.max(answer, sumScore);
            return;
        }
        DFS ( level + 1, (sumScore + nArr[level][0]), (sumTime + nArr[level][1]), nArr );
        DFS ( level + 1, sumScore, sumTime, nArr );
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 문제 개수
        M = scan.nextInt(); // 제한 시간
        int[][] nArr = new int[N][N];
        for ( int i = 0; i < N; i++ ) {
            nArr[i][0] = scan.nextInt();
            nArr[i][1] = scan.nextInt();
        }
        DFS(0, 0, 0, nArr );
        System.out.println(answer);
    }
}
