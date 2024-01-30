package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        - O(n) 으로 찾는걸 목표로 한다.
        -


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
    }
}
public class Dijkstra_Algorithm {
    static int n, m;
    static List<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for ( int i=0; i<=n; i++ ) {
            graph.add(new ArrayList<Edge>());
        }
        for ( int i=0; i<m; i++ ) {

        }
    }
}
