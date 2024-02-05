package greedy;
import java.util.*;

/*
    6. 친구인가? (Disjoint-Set : Union&Find)


    날짜 : 2024-02-05


    [설명]
    오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
    모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
    만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
    그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
    학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
    두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.


    [입력]
    첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
    다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
    마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.


    [출력]
    첫 번째 줄에 “YES"또는 "NO"를 출력한다.


    [ 공부해야 할 내용 ]
    - 서로 중복되지 않는 부분 집합 (Disjoint Set)을 표현할 때 사용하는 자료구조
    - 초기화 / 합치기 (Union) / 찾기 (Find) 세 가지 연산을 사용한다.
    - 최소 스패닝 트리를 구현하는 크루스칼 알고리즘에 사용되며, 사이클을 만들지 않고 모든 노드를 방문할 수 있다
    - 구현 방법은 다음과 같다.
        - 초기화 : N 개의 원소가 각각의 집합에 포함되어 있도록 초기화한다 -> 각각을 유일한 원소로 가지는 집합 생성
        - Union (합치기) : 두 원소 a, b 가 각각 속한 두 집합을 하나로 합친다 -> 두 개의 집합을 하나로 연결하는 역할
        - Find (찾기) : 원소 a 가 주어질 때, 이 원소가 속한 집합을 루트노드를 반환한다 -> a가 어느 집합에 속해있는지 찾는 역할

 */
public class UnionAndFind {

    static int[] unf;

    // 해당 집합과 연관이 있는지 찾아주는 함수
    public static int Find(int v) {
        if ( v == unf[v] ) return v;
        else return unf[v] = Find(unf[v]);
    }

    // 매개변수 a 와 b 를 하나의 집합으로 만들어주는 함수
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if ( fa != fb ) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 인원 수
        int M = scan.nextInt(); // 친구 쌍의 갯수
        unf = new int[N+1]; // unf 라는 배열에 각 친구와 관련된 정보를 입력 할 것이기 때문에, 인원수 만큼 배열을 만듦 ( 0은 안쓸거임 )
        for ( int i=1; i<=N; i++ ) unf[i] = i; // 우선, idx = 친구번호로 초기화
        for ( int i=1; i<=M; i++ ) { // 친구 쌍 입력
            int a = scan.nextInt();
            int b = scan.nextInt();
            Union(a, b); // a 와 b 는 친구니까, 하나의 집합으로 만들어라
        }
        int a = scan.nextInt();
        int b = scan.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if ( fa == fb ) System.out.println("YES"); // unf[v] = Find(unf[v]); 이기 때문에 가능.
        else System.out.println("NO");
    }

}
