package complex_math;
import java.util.*;
/*
    4. 연속 부분수열

    날짜 : 2023-11-01

    [설명]
    N개의 수로 이루어진 수열이 주어집니다.
    이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
    만약 N=8, M=6이고 수열이 다음과 같다면
    1 2 1 3 1 1 1 2
    합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.


    [입력]
    첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
    수열의 원소값은 1,000을 넘지 않는 자연수이다.


    [출력]
    첫째 줄에 경우의 수를 출력한다.


    [ 풀이 시간 ]
    1. 09:15 ~ 09:55 ( 풀이 실패 : RunTime Error )
    2. 10:00 ~ 10:03 ( 풀이 보고 다시 풀었음 )



    [ 공부해야 할 내용 ]
    1. pS와 pE를 활용한 Two Pointers Algorithm 을 알아야 한다.

 */

public class Sequential_Subsequence {
    public static int solution(int n, int m, int[] arr) {

        int answer = 0;
        int pS = 0;
        int sum = 0;

        for ( int pE = 0; pE < n; pE++ ) {
            sum += arr[pE];
            if ( sum == m ) answer ++;
            while (sum >= m) {
                sum -= arr[pS++];
                if ( sum == m ) answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
