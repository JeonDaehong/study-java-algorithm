package dfs_bfs;
import java.util.*;
/*
    5. 동전 교환

    날짜 : 2024-01-05

    [설명]
    다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    각 단위의 동전은 무한정 쓸 수 있다.


    [입력]
    첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
    그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


    [출력]
    첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


    [ 풀이 시간 ]
    1. 09:15 ~ 09:53


    [ 풀이 과정 ]
    1. 이 문제는 최단거리를 구하는 문제와 동일하게 BFS 를 사용해도 되지만, DFS 를 사용하여 문제를 푸는 것도 가능하다.
    2. 일반적으로 if else 로 DFS 를 만들고, 죄측 우측으로 나뉘며 a 경우와 b 경우를 탐색하게 되는데 ( DFS 를 2번 사용 ),
       이렇게 한 번 탐색한 값도 중복으로 탐색할 수 있는 경우에는
       for 문을 만들고, 그 안에 DFS 재귀를 한 번만 사용하면 된다.
    3. 원래 사용하던 DFS ( L , sum + arr[?], arr );  DFS ( L, sum, arr ) 방식은 사용할 수 없다.
       그 이유는 arr 안에 저장된 값을 한 번만 사용하는게 아니라, 중복해서 계속 사용할 수 있기 때문이다.
       한 번만 사용 가능한 ( ex. 바둑이 문제 ) 경우는
       DFS ( L , sum + arr[?], arr );  DFS ( L, sum, arr ) 방식을 사용하면 된다.


 */
public class Coin_Exchange_DFS {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    public static void DFS(int level, int sum, Integer[] arrN) {
        if ( sum > M ) return;
        if ( level >= answer ) return;
        if ( sum == M ) {
            answer = Math.min(answer, level);
        } else {
            for ( int i = 0; i < N; i++ ) { // 각 동전을 추가한 각각의 경우를 나누어서 재귀함수 호출
                DFS(level + 1, sum + arrN[i], arrN);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        Integer[] arrN = new Integer[N];
        for ( int i=0; i<N; i++ ) {
            arrN[i] = scan.nextInt();
        }
        // 시간효율성을 위해 큰 수부터 대입하도록 내림차순 정렬 ( 이걸 위해 Wrapper Type 으로 배열을 저장 )
        Arrays.sort(arrN, Collections.reverseOrder());
        M = scan.nextInt();
        DFS(0, 0, arrN);
        System.out.println(answer);
    }

}
