package dfs_bfs;
import java.util.*;

/*
    12. 토마토 ( BFS )

    날짜 : 2024-01-15

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
    1. 09:00 ~ 10:03


    [ 풀이 과정 ]
    1. 2차원 배열을 돌며, 육지(1) 를 찾는다.
    2. 육지를 찾으면 8방향으로 재귀를 돌며 붙어있는 육지가 있는지를 찾는다.
    3. 육지가 있으면 다 0 으로 바꿔준다.
    4. 이후 answer 를 1 상승시켜준다.
    5. 그렇게 2차원 배열을 전부 돌면 된다.

 */
public class Island {

    static int answer;
    static int N;
    static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상, 하, 좌, 우, 좌상단, 우상단, 좌하단, 우하단
    static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상, 하, 좌, 우, 좌상단, 우상단, 좌하단, 우하단

    public static void solution(int[][] arr) {
        for ( int i=0; i<N; i++ ) {
            for (int j = 0; j < N; j++) {
                if ( arr[i][j] == 1 ) {
                    DFS(i, j, arr);
                    answer++;
                }
            }
        }
    }

    public static void DFS(int x, int y, int[][] arr) {
        for ( int i=0; i<8; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 1 ) {
                arr[nx][ny] = 0;
                DFS(nx, ny, arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int[][] arr = new int[N][N];
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<N; j++ ) {
                arr[i][j] = scan.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }

}
