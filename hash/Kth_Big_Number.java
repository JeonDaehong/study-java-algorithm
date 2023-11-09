package hash;
import java.util.*;
/*
    6. K번째 큰 수

    날짜 : 2023-11-09

    [설명]
    현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
    현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
    기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
    만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.


    [입력]
    첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.


    [출력]
    첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.


    [ 풀이 시간 ]
    1. 09:32 ~ 09:55 ( 성공, 근데 문제 잘 읽을 것. 실패시 -1 출력하라고 하는 것 잘 볼 것 )


    [ 공부해야 할 내용 ]
    1. 문제에 입력값 범위를 잘 보고 생각
       여기서는 최대 100개를 3중 for문 해도 i+1, j+1로 시작해서 O(n^3)보다 적음. 3중 for문을 해도 Run Time Error가 안 생김.
    2. 같은 배열에서 중복 없이 for문을 돌리려면,
       i=0, j=i+1로 하면 됨.
    3. 중복되지 않는 값을 넣는 자료구조에는 HashSet도 있지만, reverseOrder()처럼 자동으로 정렬해주는걸 사용하고 싶으면,
       TreeSet 도 좋음. TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());


 */
public class Kth_Big_Number {
    public static int solution(int n, int k, int[] arr) {
        int answer = -1;

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for ( int i=0; i<n; i++ ) {
            for ( int j=i+1; j<n; j++ ) {
                for ( int l=j+1; l<n; l++ ) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for ( int x : tSet ) {
            cnt ++;
            if ( cnt == k ) return x;
        }

        return answer;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
}
