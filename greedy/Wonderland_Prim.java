package greedy;
import java.util.*;
/*
    8. 원더랜드 ( 최소 스패닝 트리 ) / Prim Algorithm 방법으로 풀이

    날짜 : 2024-02-13

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
    총 풀이시간 09:40 ~ 10:32
        - 문제 분석 ( 09:40 ~ 09:41 ) // 이미 다른 알고리즘으로 푼 같은 문제
        - 손 코딩 ( 09:42 ~ 10:03 )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 10:04 ~ 10:22 )
        - 코드 구현 ( 10:23 ~ 10:32 )


    [ 문제 풀이 순서 ]
    - vex 와 cost 를 담을 수 있는 클래스를 만들어준다. ( 오름차순 재정의 )
    - List<ArrayList<Class>> 형식의 리스트를 만든다. 여기서 ArrayList 의 인덱스가 출발 Node, Class 의 vex 가 도착 Node 가 되며, cost 가 그 사이 비용이다.
    - Queue<Class> pQ = new PriorityQueue<>(); 는 재정의 한 정렬 방식으로 하여 작은 수 부터 꺼내온다.
    - 이후에는 ch[vex] 가 0인 경우 ( 아직 간선을 선택하지 않은 경우 ) 의 cost 중 가장 작은 cost 를 answer 에 더해주고, ch[vex] = 1 을 해준다.
    - 그러면, 가장 최선의 cost 를 가진 간선만 더한 채로 Queue 의 모든 데이터를 poll 시킬 수 있다.

 */

class WonderEdgePrim implements Comparable<WonderEdgePrim> {
    public int vex, cost;
    public WonderEdgePrim(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(WonderEdgePrim o) {
        return this.cost - o.cost; // 오름차순
    }
}
public class Wonderland_Prim {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        int V = scan.nextInt();
        int E = scan.nextInt();
        int[] ch = new int[V+1];
        List<ArrayList<WonderEdgePrim>> nodeList = new ArrayList<>();
        for ( int i=0; i<=V; i++ ) {
            nodeList.add(new ArrayList<>());
        }
        for ( int i=0; i<E; i++ ) {
            int node1 = scan.nextInt();
            int node2 = scan.nextInt();
            int cost = scan.nextInt();
            nodeList.get(node1).add(new WonderEdgePrim(node2 ,cost));
            nodeList.get(node2).add(new WonderEdgePrim(node1 ,cost)); // 무방향 그래프이므로, 반대 방향도 입력해주어야 함.
        }
        Queue<WonderEdgePrim> pQ = new PriorityQueue<>();
        pQ.offer(new WonderEdgePrim(1, 0));
        while( !pQ.isEmpty() ) {
            WonderEdgePrim nowEdge = pQ.poll();
            int nowVex = nowEdge.vex;
            if ( ch[nowVex] == 0 ) {
                ch[nowVex] = 1;
                answer += nowEdge.cost;
                for ( WonderEdgePrim edge : nodeList.get(nowVex) ) {
                    if ( ch[edge.vex] == 0 ) pQ.offer(new WonderEdgePrim(edge.vex, edge.cost));
                }
            }
        }
        System.out.println(answer);
    }

}
