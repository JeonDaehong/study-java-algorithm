package dfs_bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    11. 미로 탐색 최단거리 찾기 ( BFS )

    날짜 : 2024-01-13

    [설명]
    7 * 7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
    출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
    격자판의 움직임은 상하좌우로만 움직인다.


    [입력]
    7*7 격자판의 정보가 주어집니다.


    [출력]
    첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.


    [ 풀이 시간 ]
    1. 11:20 ~ 12:01


    [ 풀이 과정 ]
    1. 다음 Point 를 저장할 class 를 만들어준다.
    2. dis[x][y] 에 현재 깊이를 저장해준다.
    3. DFS 처럼 모든 곳을 순회 하는 개념이 아니라, 현재 갈 수 있는 모든 곳을 동시에 가면서 계산한다고 생각하면 된다.
    4. dis 에는 각 좌표의 깊이가 꽉 채워지게 된다.
    5. 거기서 dis[N][N] 의 값을 꺼내면 된다.

 */
class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Maze_Navigation2 {

    static int N;
    static int[][] maze;
    static int[][] dis;
    static int[] dx = {1, 0, -1, 0}; // 우, 상, 좌, 하
    static int[] dy = {0, 1, 0, -1}; // 우, 상, 좌, 하



    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        maze[x][y] = 1;
        while ( ! queue.isEmpty() ) {
            Point tempPoint = queue.poll();
            for ( int i=0; i<4; i++ ) {
                int nx = tempPoint.x + dx[i];
                int ny = tempPoint.y + dy[i];
                if ( nx >= 0 && nx <= N && ny >= 0 && ny <= N && maze[nx][ny] == 0 ) {
                    maze[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tempPoint.x][tempPoint.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        maze = new int[N+1][N+1];
        dis = new int[N+1][N+1];
        for ( int i=1; i<=N; i++ ) {
            for ( int j=1; j<=N; j++ ) {
                maze[i][j] = scan.nextInt();
            }
        }
        BFS(1, 1);
        if ( dis[N][N] == 0 ) System.out.println(-1);
        else System.out.println(dis[N][N]);
    }

}
