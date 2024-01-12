package dfs_bfs;

import java.util.Scanner;

/*
    10. 미로 탐색

    날짜 : 2024-01-12

    [설명]
    7 * 7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
    출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
    격자판의 움직임은 상하좌우로만 움직인다.


    [입력]
    7*7 격자판의 정보가 주어집니다.


    [출력]
    첫 번째 줄에 경로의 가지수를 출력한다.


    [ 풀이 시간 ]
    1. 10:00 ~ 10:29


    [ 풀이 과정 ]
    1. 원래 우리가 풀어왔던 미로 문제처럼, dx dy 를 통해 nx 와 ny 를 구해야 한다.
    2. 모든 방향으로 갈 수 있는 곳은 다 계산해야 되기 때문에,
       if ( nx >= 0 && nx <= N-1 && ny >= 0 && ny <= N-1 && maze[nx][ny] == 0 ) 를 활용한다.
    3. 왔던 곳을 다시 돌아갈 수는 없기 때문에 check 배열을 활용해준다.

 */
public class Maze_Navigation {

    static int answer;
    static int[][] maze;
    static boolean[][] check;
    static int N;
    static int[] dx = {1, 0, -1, 0}; // 우, 상, 좌, 하
    static int[] dy = {0, 1, 0, -1}; // 우, 상, 좌, 하

    public static void DFS(int x, int y) {
        if ( x == N-1 && y == N-1 ) {
            answer ++;
        } else {
            for ( int i=0; i<4; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ( nx >= 0 && nx <= N-1 && ny >= 0 && ny <= N-1 && maze[nx][ny] == 0 ) {
                    if ( ! check[nx][ny] ) {
                        check[nx][ny] = true;
                        DFS(nx, ny);
                        check[nx][ny] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        maze = new int[N][N];
        check = new boolean[N][N];
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<N; j++ ) {
                maze[i][j] = scan.nextInt();
            }
        }
        check[0][0] = true;
        DFS(0,0);
        System.out.println(answer);
    }

}
