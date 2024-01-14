package dfs_bfs;
import java.util.*;

/*
    12. 토마토 ( BFS )

    날짜 : 2024-01-14

    [설명]
    현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
    토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
    창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
    익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
    하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
    토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
    토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
    며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


    [입력]
    첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,
    N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.
    둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
    즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
    하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.


    [출력]
    여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
    만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
    토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.


    [ 풀이 시간 ]
    1. 11:05 ~ 11:37 ( 모르는 부분 참고해가며 풀었기 때문에, 나중에 꼭 다시 풀어 볼 것 )


    [ 풀이 과정 ]
    1. 미로와 다르게 출발지점이 여러개일 수 있으므로, Queue 를 전역변수로 선언하여,
       처음 2차원 배열을 scanner 로 입력할 때, if ( tomatoBox[i][j] == 1 ) queue.offer(new TomatoPoint(i, j)); 를 넣어준다.
    2. 처음 2차원 배열을 scanner 로 입력할 때 Queue 에 offer 를 해줬으므로 BFS 내에서는 따로 해줄 필요는 없다.
    3. BFS 안에서는 토마토가 있는 이차원 배열과, 깊이를 측정하는 dis 이차원 배열을 가지고 다음으로 뻗어나갈 수 있는지를 확인하여 뻗어나간다.
    4. BFS 가 끝난 후, 토마토가 들어있는 배열에 0이 남아있다면, 인접한 익은 토마토가 없는 경우이기 때문에 무조건 -1 을 return 해주어야 하므로
       for 문을 돌며 0이 있는지 확인한다. ( boolean check 을 활용 )
    5. 그러면서 동시에 answer 와 dis[i][j] 를 가지고 더 큰 수를 answer 에 대입하며 비교한다.
       - 기본적으로 BFS 를 전부 돌면 모든 곳을 저장할 수 있는 최단 거리가 저장되기 때문에
       - Math.max 로 비교해주어도 상관 없는 것이다.
    6. check 가 true 면 answer 를 출력하고, check 가 false 면 -1 을 출력한다.

 */

class TomatoPoint {
    int x, y;
    public TomatoPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Tomato {
    static int answer = Integer.MIN_VALUE;
    static int N, M;
    static int[][] tomatoBox;
    static int[][] dis;
    static Queue<TomatoPoint> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0}; // 우, 상, 좌, 하
    static int[] dy = {0, 1, 0, -1}; // 우, 상, 좌, 하

    public static void BFS() {
        while ( !queue.isEmpty() ) {
            TomatoPoint tp = queue.poll();
            for ( int i=0; i<4; i++ ) {
                int nx = tp.x + dx[i];
                int ny = tp.y + dy[i];
                if ( ny >= 0 && nx >=0 && nx < N && ny < M && tomatoBox[nx][ny] == 0 ) {
                    tomatoBox[nx][ny] = 1;
                    queue.offer(new TomatoPoint(nx, ny));
                    dis[nx][ny] = dis[tp.x][tp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        tomatoBox = new int[N][M];
        dis = new int[N][M];
        for ( int i=0; i<N; i++ ) {
            for (int j=0; j<M; j++ ) {
                tomatoBox[i][j] = scan.nextInt();
                if ( tomatoBox[i][j] == 1 ) queue.offer(new TomatoPoint(i, j));
            }
        }
        BFS(); // BFS 시작
        for ( int i=0; i<N; i++ ) {
            for (int j=0; j<M; j++ ) {
                System.out.print(tomatoBox[i][j] + " ");
            }
            System.out.println();
        }

        boolean checkFlag = true;
        for ( int i=0; i<N; i++ ) {
            for (int j=0; j<M; j++ ) {
                answer = Math.max(answer, dis[i][j]);
                if (tomatoBox[i][j] == 0) {
                    checkFlag = false;
                    break;
                }
            }
        }

        if ( checkFlag ) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
