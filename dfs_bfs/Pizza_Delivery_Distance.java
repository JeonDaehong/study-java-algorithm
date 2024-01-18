package dfs_bfs;
import java.util.*;

/*
    15. 피자 배달 거리

    날짜 : 2024-01-18

    [설명]
    N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
    각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
    행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
    도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
    피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
    집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

    (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
    최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
    도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
    시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
    도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.


    [입력]
    첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
    둘째 줄부터 도시 정보가 입력된다.


    [출력]
    첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.


    [ 풀이 시간 ]
    1. 10:11 ~ 11:45 ( 중간에 풀이과정을 조금 참고하였음 )


    [ 풀이 과정 ]
    1. 조합 경우의 수는 DFS ( int L, int start ) 공식을 외워야 한다. 그리고 for ( int i=start; i<len; i++ ) 로 순회하는 것도 기억해야 한다.
    2. 필자는 섬 찾기 문제랑 혼동이 있었는데, 배열에서 0, 1, 2가 있다고 해서, 이중 for 문으로 돌면서 1, 2 의 경우를 계산하려고 했다. 그건 함정이다.
    3. 어차피 집과 남아있는 예상 피자집들의 거리를 중 최소거리를 구해야 하는 것이다.
       공식도 |x1-x2|+|y1-y2|
       이렇게 친절하게 알려주고 있다.
    4. houseList 와, pizzaList 에 각 집과 피자집의 좌표를 저장한다. ( Point 클래스를 활용했다. )
    5. DFS( level, start ) 를 통해
       ?개의 피자집 중 M개의 피자집을 선택하는 ( ?Cm ) 모든 경우의 수 별로,
       모든 house 의 피자집 최소 거리를 구해준다.
       그리고 그걸 합 한다.
       마지막으로, 그 합 중 가장 최소값을 구해서 return 해주면 된다.


 */
public class Pizza_Delivery_Distance {
    static int N, M, len;
    static List<Point> houseList, pizzaList;
    static int[] combination;
    static int answer = Integer.MAX_VALUE;
    public static void DFS(int L, int start) {
        if ( L == M ) {
            int disSum = 0;
            for ( Point house : houseList ) {
                int dis = Integer.MAX_VALUE;
                for ( int i : combination ) {
                    dis = Math.min(dis, Math.abs(house.x - pizzaList.get(i).x) + Math.abs(house.y - pizzaList.get(i).y));
                }
                disSum += dis;
            }
            answer = Math.min(answer, disSum);
        } else {
            for ( int i=start; i<len; i++ ) {
                combination[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        houseList = new ArrayList<>();
        pizzaList = new ArrayList<>();
        for ( int i=0; i<N; i++ ) {
            for ( int j=0; j<N; j++ ) {
                int tmp = scan.nextInt();
                if ( tmp == 1 ) houseList.add(new Point(i, j));
                if ( tmp == 2 ) pizzaList.add(new Point(i, j));
            }
        }
        len = pizzaList.size();
        combination = new int[M];
        DFS(0, 0);
        System.out.println(answer);
    }
}
