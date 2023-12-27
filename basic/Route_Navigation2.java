package basic;
import java.util.*;
/*
    10. 경로 탐색 ( 인접 리스트 / DFS )

    날짜 : 2023-12-27

    [설명]
    방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.


    [입력]
    첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어집니다. 그 다음주터 M줄에 걸쳐 연결 정보가 주어집니다.


    [출력]
    총 가지수를 출력합니다.


    [ 풀이 시간 ]
    1. 09:35 ~ 10:01


    [ 공부해야 할 내용 ]
    1. 정점의 수가 10,000 개 이상 막 그렇게 많을 경우에는 인접 리스트를 사용하고,
       정점의 수가 적을 경우에는 인접 행렬을 사용한다.
    2. 정점 개수만큼 ArrayList 를 만든다.
       그리고 해당 정점에서 갈 수 있는 정점들을 리스트에 집어 넣는다.
       ex ) 1번 점점에서는 2, 3, 5번 정점을 갈 수 있다면
            1 이라는 리스트에 2, 3, 5를 넣는다.
    3. 인접 행렬 방식에서 graph 를 배열 대신 리스트를 사용한다고 보면 된다.


 */
public class Route_Navigation2 {

    static int n, m, answer = 0;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public static void DFS(int v) {
        if ( v == n ) answer ++;
        else {
            for ( int nv : graph.get(v) ) {
                if ( !ch[nv] ) {
                    ch[nv] = true;
                    DFS(nv);
                    ch[nv] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for ( int i=0; i<n; i++ ) {
            graph.add(new ArrayList<>());
        }
        ch = new boolean[n+1];
        for (int i=0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = true;
        DFS(1);
        System.out.println(answer);
    }

}
