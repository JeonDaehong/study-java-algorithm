package dfs_bfs;
import java.util.*;

/*
    14. 섬나라 아일랜드 ( BFS )

    날짜 : 2024-01-17

    [설명]
    N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
    각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
    섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
    두 번째 줄부터 격자판 정보가 주어진다.


    [출력]
    첫 번째 줄에 섬의 개수를 출력한다.


    [ 풀이 시간 ]
    1. 09:32 ~ 10:01


    [ 풀이 과정 ]
    1. DFS 와 푸는 방법은 비슷하다.
    2. 다만 Queue 를 활용하여 BFS로도 풀 수 있을 뿐이다.

 */
class IslandPoint {
    int x, y;
    public IslandPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Island2 {

    static int answer;
    static int N;
    static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상, 하, 좌, 우, 좌상단, 우상단, 좌하단, 우하단
    static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상, 하, 좌, 우, 좌상단, 우상단, 좌하단, 우하단

    public static void BFS(int x, int y, int[][] arr) {
        Queue<IslandPoint> queue = new LinkedList<>();
        queue.offer(new IslandPoint(x, y));
        while ( ! queue.isEmpty() ) {
            IslandPoint tp = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tp.x + dx[i];
                int ny = tp.y + dy[i];
                if ( nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1 ) {
                    arr[nx][ny] = 0;
                    queue.offer(new IslandPoint(nx, ny));
                }
            }
        }
    }

    public static void solution(int[][] arr) {
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<N; j++ ) {
                if ( arr[i][j] == 1 ) {
                    BFS(i, j, arr);
                    answer ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int[][] board = new int[N][N];
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<N; j++ ) {
                board[i][j] = scan.nextInt();
            }
        }
        solution(board);
        System.out.println(answer);
    }
}
