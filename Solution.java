import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int m, n;
    int[] dx = {-1, 0, 1, 0}; // 좌, 상, 우, 하
    int[] dy = {0, -1, 0, 1};// 좌, 상, 우, 하
    public int BFS(int x, int y, int[][] mat) {
        Queue<Point> queue = new LinkedList<>();
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = -1;
            }
        }
        queue.offer(new Point(x, y));
        dis[x][y] = 0;
        while ( ! queue.isEmpty() ) {
            Point tp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tp.x + dx[i];
                int ny = tp.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && dis[nx][ny] == -1) {
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tp.x][tp.y] + 1;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    minDistance = Math.min(minDistance, dis[i][j]);
                }
            }
        }

        return minDistance;
    }
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        if ( m == 0 )return null;
        n = mat[0].length;
        int[][] answer = new int[m][n];
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( mat[i][j] == 1 ) {
                    answer[i][j] = BFS(i, j, mat);
                } else {
                    answer[i][j] = 0;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int [N][M];
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<M; j++ ) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int [][] answer = solution.updateMatrix(arr);
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<M; j++ ) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}