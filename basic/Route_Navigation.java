package basic;
import java.util.*;
/*
    9. 경로 탐색 ( 인접 행렬 / DFS )

    날짜 : 2023-12-23

    [설명]
    방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.


    [입력]
    첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어집니다. 그 다음주터 M줄에 걸쳐 연결 정보가 주어집니다.


    [출력]
    총 가지수를 출력합니다.


    [ 풀이 시간 ]
    1. 12:45 ~ 13:03


    [ 공부해야 할 내용 ]
    1. 그래프의 인접 행열에 대하여 알아야 한다.
    2. 그래프와 인접행렬
        Graph 는 Vertex 와 Edge 로 이루어져있다.
        Vertex 는 Node 를 의미하고, Edge 는 Node 사이를 연결하는 선을 의미한다.
    3. 그래프에는
        1. 무방향 그래프 ( 양방향 그래프 )
        2. 방향 그래프 ( 단반향 그래프 )
        3. 가중치 방향 그래프
        세 가지가 있다.
    4. 이걸 인접행렬 방식으로 만들어서 값을 구하면 아래와 같다.
        무방향은 양방향이므로,
        1 - 2 - 3 이면

           1  2  3
        1  0  1  0
        2  1  0  1
        3  0  1  0

        이 되고,

        방향 그래프는 단방향이므로

        1 -> 2 -> 3 이면

           1  2  3
        1  0  1  0
        2  0  0  1
        3  0  0  0

        이 되고,

        가중치 방향 그래프는

        1 --2--> 2 --5--> 3 이면

           1  2  3
        1  0  2  0
        2  0  0  5
        3  0  0  0

        이렇게 된다.



 */
public class Route_Navigation {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void DFS(int v) {
        if ( v == n ) answer ++;
        else {
            for ( int i=1; i<=n; i++ ) {
                if ( graph[v][i] == 1 && ch[i] == 0 ) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for ( int i=1; i<=m; i++ ) {
            graph[scan.nextInt()][scan.nextInt()] = 1;
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
