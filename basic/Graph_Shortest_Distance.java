package basic;
import java.util.*;
/*
    11. 최단거리 구하기 ( 그래프 / BFS )

    날짜 : 2023-12-28

    [설명]
    1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.


    [입력]
    첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어집니다. 그 다음주터 M줄에 걸쳐 연결 정보가 주어집니다.


    [출력]
    1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례로 출력합니다.


    [ 풀이 시간 ]
    1. 09:35 ~ 10:21


    [ 공부해야 할 내용 ]
    1. 최단거리 = BFS 로 구하면 된다.
    2. level 변수 대신, arrLevel 배열을 활용하는 걸 알아야 한다. ( 추후 2차원 배열 BFS 를 위해서 )
    3. 정점에서 다음 정점의 거리만큼 더해주는 것이므로, dis[nv] = dis[cv] + 1; 을 잘 이용해야한다. ( 이해 할 것 )


 */
public class Graph_Shortest_Distance {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] ch;
    static int[] dis;

    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = true;
        dis[v] = 0;
        Q.offer(v);
        while ( !Q.isEmpty() ) {
            int cv = Q.poll();
            for ( int nv : graph.get(cv) ) {
                if ( !ch[nv] ) {
                    ch[nv] = true;
                    Q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for ( int i=0; i<=n; i++ ) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        ch = new boolean[n+1];
        dis = new int[n+1];
        BFS(1);
        for ( int i=2; i<=n; i++ ) {
            System.out.println( i + " : " + dis[i]);
        }
    }
}
