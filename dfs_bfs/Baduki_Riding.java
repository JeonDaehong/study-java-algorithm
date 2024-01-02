package dfs_bfs;
import java.util.*;
/*
    2. 바둑이 승차

    날짜 : 2024-01-02

    [설명]
    철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C kg 넘게 태울수가 없다.
    철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
    N 마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
    둘째 줄부터 N마리 바둑이의 무게가 주어진다.


    [출력]
    첫 번째 줄에 가장 무거운 무게를 출력한다.


    [ 풀이 시간 ]
    1. 09:00 ~ 09:26


    [ 풀이 과정 ]
    1. 트럭 무게와 sum 의 무게가 일치할 경우 flag 를 true 만들고 계속 return 하여 빠르게 Stack 이 pop 될 수 있게 하는 것이 좋다.
    2. DFS 의 끝까지 가지 않더라도, sum 이 트럭 혀용 무게인 C 보다 커질 경우 return 시키는 것이 좋다.
    3. 리프 노드 ( 자식이 없는 끝 노드 ) 에 도달 하였을 때 sum 이 C 보다 작으면 answer 에 저장된 값과 sum 을 비교하고, sum 이 더 크다면
       answer 에 sum 의 값을 저장해 준다.

    또한, 부분집합 구하는 문제와 동일한 문제이기 때문에 DFS 에서는 다음 배열에 담긴 수 ( 여기서는 해당 무게를 가진 바둑이 ) 를 포함시키느냐 안시키느냐를
    정하면 된다.
    DFS ( L+1, sum + arrN[L], arrN );
    DFS ( L+1, sum, arrN);


 */
public class Baduki_Riding {
    static int answer = Integer.MIN_VALUE;
    static int C, N;
    static boolean flag;
    public static void DFS(int L, int sum, int[] arrN) {
        if ( flag ) return;
        if ( sum > C ) return;
        if ( C == sum ) {
            answer = sum;
            flag = true;
            return;
        } if ( L == N ) {
            if ( sum > answer ) answer = sum;
            return;
        } else {
            DFS ( L+1, sum + arrN[L], arrN );
            DFS ( L+1, sum, arrN);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        C = scan.nextInt();
        N = scan.nextInt();
        int[] arrN = new int[N];
        for ( int i=0; i<N; i++ ) {
            arrN[i] = scan.nextInt();
        }
        DFS(0, 0, arrN);
        System.out.println(answer);
    }
    
}
