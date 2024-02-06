package greedy;
import java.util.*;
/*
    7. 원더랜드 ( 최소 스패닝 트리 ) / Union & Find 방법으로 풀이


    날짜 : 2024-02-06


    [설명]
    원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
    원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
    위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.


    [입력]
    첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
    다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
    이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.


    [출력]
    모든 도시를 연결하면서 드는 최소비용을 출력한다.


    [ 풀이 시간 ]
    총 풀이시간 09:40 ~ 10:39
        - 문제 분석 ( 09:40 ~ 09:45 )
        - 손 코딩 ( 09:46 ~ 10:04 )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 10:05 ~ 10:20 )
        - 코드 구현 ( 10:21 ~ 10:39 )


    [ 문제 풀이 순서 ]
    - Edge Class 를 implements Comparable 받아서 compareTo 메서드를 오름차순으로 재정의 하여 만들기
    - Edge 를 담을 List 와, Union & Find 알고리즘을 위한 노드를 담을 배열 만들기
    - Union & Find 메서드 만들기.
    - 배열을 노드 개수만큼으로 순서대로 초기화하고, Edge 를 입력 정보만큼 List 에 담기
    - List sort 하기
    - Edge 안에 담긴 v1(간선1) 과 v2(간선2) 를 Find 하여 비교하고, 값이 서로 다를경우 ( 다를 경우가 최초 연결 지점임 ) 가중치를 answer 에 더해준다.
    - 그리고 answer 에 더해준 Edge 정보는 Union 해주어, 이후에 같은 노드에서 같은 노드로 이어지는 또 다른 간선이 존재할 경우, Find(v1) Find(v2) 값이 같게 만들어준다.
    - 그럼 그건 최소 가중치가 아니므로 자연스럽게 answer 에 포함되지 않게 된다.

 */

// Comparable 로 compareTo 를 재정의한 Edge Class
class WonderEdge implements Comparable<WonderEdge> {
    public int v1, v2, cost;
    public WonderEdge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(WonderEdge o) {
        return this.cost - o.cost; // 오름차순
    }
}
public class Wonderland_UnionAndFind {

    // Field
    static List<WonderEdge> edgeList;
    static int[] unf;

    // Find Method
    static int Find(int v) {
        if ( v == unf[v] ) return v;
        else return unf[v] = Find(unf[v]);
    }

    // Union Method
    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if ( fa != fb ) unf[fa] = fb;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt(); // 정점
        int E = scan.nextInt(); // 간선

        // unf 배열 초기화
        unf = new int[V + 1];
        for ( int i=1; i<=V; i++ ) {
            unf[i] = i;
        }

        // 정점과 간선 관련 정보를 List 에 넣기
        edgeList = new ArrayList<>();
        for ( int i=1; i<=E; i++ ) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int cost = scan.nextInt();
            edgeList.add(new WonderEdge(v1, v2, cost));
        }

        // List 정렬하기
        Collections.sort(edgeList);

        // cost 가 작은 순서부터, 하여 A Node 에서 B Node 로 연결되는 작은 하나의 간선 정보만을 가지고 answer 에 대입을 시킨다.
        int answer = 0;
        for ( WonderEdge edge : edgeList ) {
            int fa = Find(edge.v1);
            int fb = Find(edge.v2);
            if ( fa != fb ) {
                answer += edge.cost;
                unf[fa] = fb;
            }
        }

        // 정답
        System.out.println(answer);
    }

}
