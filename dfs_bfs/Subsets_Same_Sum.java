package dfs_bfs;
import java.util.*;
/*
    1. 합이 같은 부분집합

    날짜 : 2023-12-29

    [설명]
    N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
    두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
    둘로 나뉘는 두 부분집합은 서로소 집합(공통 집합이 없음)이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
    예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.


    [입력]
    첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
    두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.


    [출력]
    첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.


    [ 풀이 시간 ]
    1. 09:30 ~ 10:19


    [ 공부해야 할 내용 ]
    1. 매개변수로 계속 재귀해서 넘길거만 지역변수로 선언, 나머지 공용쓰로 쓰이는건 전역변수로 선언하는게 좋다.
    2. 이 문제를 이해하려면, 다음과 같다.
       왼쪽은 level, 오른쪽은 sum 이라 하였을 때,
       처음에는 ( 0, 0 ) 으로 시작하여 재귀함수를 돌린다,
       그 아래에는 level + 1 과 sum + arr[level] 인 ( 1, 1 ) 과 level + 1만 한, ( 1. 0 ) 이 된다.
       그 이유는 arr[0] 이 부분집합에 포함됐느냐 안됐느냐의 차이이다.
       지금은 arr[0] 이 1인데, 왼쪽으로 가면 부분집합에 1이 들어간거고, 오른쪽으로 가면 부분집합에 1이 들어가지 않은거라 할 수 있다.
       ( 1, 1 ) 방향으로 갔다고 가정하자.
       arr[1] 은 3이기 때문에 다음 DFS는 ( 2, 4 ) 아니면 ( 2, 1 ) 로 이어진다.
       왼쪽으로 가면 { 1, 3 } 인 거고, 오른쪽으로 가면 { 1 } 인 셈이다.
       그렇게 마지막까지 도달했을 때의 집합의 합이 total / 2 와 같은게 있다면 "YES" 를 출력하면 된다.
       ( 참고로 total 은 모든 원소의 합을 미리 저장해둔 변수이다. )


 */
public class Subsets_Same_Sum {

    static String answer = "NO";
    static int n, total;
    static boolean signal;

    public static void DFS(int level, int sum, int[] arr) {
        if ( signal ) return;
        if ( sum > (total/2) ) return;
        if ( level == n && (total - sum) == sum ) { // level 이 0부터 시작, 원소 갯수가 5라면, 0,1,2,3,4 배열을 다 더하고 ( 총 5번 ) 와야지 부분집합 완성이다.
            answer = "YES";
            signal = true;
        } else {
            DFS(level + 1, sum+arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }

}
