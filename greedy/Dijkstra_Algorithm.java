package greedy;

import java.util.*;

/*
    5. 다익스트라 알고리즘

    날짜 : 2024-01-30

    [설명]
    아래의 "가중치 방향그래프"에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.
    ( 경로가 없으면 Impossible 을 출력한다. )


    [입력]
    첫째 줄에는 정점의 수 N(1<=N<=20) 과 간선의 수 M이 주어진다.
    그 다음부터 M줄에 걸쳐 연결 정보와 거리 비용이 주어진다.


    [출력]
    1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.


    [ 공부해야 할 내용 ]
    - 다익스트라 알고리즘에 대하여 공부
        - 다익스트라 알고리즘은 음의 가중치(음의 간선, 음의 값)가 없는 그래프의 한 노드에서 각 모든 노드까지의 최단거리를 구하는 알고리즘을 말한다.
    - 해당 문제 풀이 방법
        - Edge 라는 객체를 만들어서, Node 를 저장하는 vex 와, 그에 대한 가중치인 cost 를 변수로 만든다.
        - 그리고 cost 는 작은 수부터 오름차순으로 정렬하게끔 compareTo 를 재정의 해준다.
            - 왜냐하면 보통 다익스트라 알고리즘에서는 PriorityQueue 를 사용하는데,
            - 이는 사용자가 지정한 우선순위에 의거하여 원소를 꺼내는 특징이 있기 때문이다.
        - 이후, List<List<Edge>> 와 배열 dis 를 정의해준다.
            - List 에는 예를들어 List.get(1) 이면,
            - 1번에서 갈 수 있는 Edge 의 List 가 들어가게 된다.
            - dis 는 전부 Integer.MAX_VALUE 로 지정해준다.
        - 그 후 시작점인 1부터 시작해주면 된다.
        - 처음에는 1 --> 1인, Edge(1, 0) 이 들어가게되고
        - 이후 1에서 갈 수 있는 Node 를 전부 탐색하며 간다.
        - 그리고 1번에서 3번으로 갈 수 있다고 가정하면, 그걸 Queue 에 또 넣어주고,
        - 그 3번에서 갈 수 있는 최소 가중치를 계산해주며 계속 이동하게 된다.
        - 그리고 해당 vex 에 도달하면 작은 값을 항상 dis[vex] 에 저장해두어야 한다.


 */
class Edge implements Comparable<Edge> {
    int vex, cost;
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    } // 작은 수부터 오름차순으로 나열
}
public class Dijkstra_Algorithm {

    static int n, m;
    static List<ArrayList<Edge>> graph;
    static int[] dis;

    public static void solution(int s) {
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(s, 0)); // 처음엔  1번 Node --> 1번 Node 로 가는 가중치를 집어넣음.
        dis[s] = 0; // dis 에도 그 값을 집어넣어줌.
        while ( ! pQ.isEmpty() ) {
            Edge tmpEdge = pQ.poll();
            int now = tmpEdge.vex;
            int nowCost = tmpEdge.cost;
            if ( nowCost > dis[now] ) continue;
            for ( Edge obEdge : graph.get(now) ) {
                if ( dis[obEdge.vex] > nowCost + obEdge.cost ) {
                    dis[obEdge.vex] = nowCost + obEdge.cost;
                    pQ.offer(new Edge(obEdge.vex, nowCost + obEdge.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList<>();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for ( int i=0; i<=n; i++ ) {
            graph.add(new ArrayList<>());
        }
        for ( int i=0; i<m; i++ ) {
            graph.get(scan.nextInt()).add(new Edge(scan.nextInt(), scan.nextInt()));
        }
        for ( int i=2; i<=n; i++ ) {
            if ( dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible " );
        }
    }
}
