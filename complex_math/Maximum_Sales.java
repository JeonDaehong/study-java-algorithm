package complex_math;
import java.util.*;
/*
    3. 최대 매출

    날짜 : 2023-10-30

    [설명]
    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
    만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
    12 1511 20 2510 20 19 13 15
    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
    여러분이 현수를 도와주세요


    [입력]
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


    [출력]
    첫 줄에 최대 매출액을 출력합니다.


    [ 풀이 시간 ]
    1. 11:50 ~ 11:56 ( 풀이 실패 : Time Limit Exceeded )
    2. 12:00 ~ 12:06 ( 풀이 실패 : Time Limit Exceeded )
    3. 12:25 ~ 12:39 ( 풀이 성공 : Sliding Window Algorithm 공부 후 )
    


    [ 공부해야 할 내용 ]
    1. Sliding Window Algorithm 공부하기

 */
public class Maximum_Sales {
    
    // Time Limit Exceeded 풀이
    public static int maxSales(int n, int m, int[] arr) {
        int answer = 0;
        for ( int i=0; i<n-(m+1); i++ ) {
            int sum = 0;
            for ( int j=i; j<i+m; j++ ) {
                sum += arr[j];
            }
            if ( answer < sum ) answer = sum;
        }
        return answer;
    }

    // Time Limit Exceeded 풀이 2
    public static int maxSales2(int n, int m, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = m-1;
        while (maxIdx < n) {
            int sum = 0;
            for ( int i = minIdx; i <= maxIdx; i++ ) {
                sum += arr[i];
            }
            if ( answer < sum ) answer = sum;
            minIdx++;
            maxIdx++;
        }

        return answer;
    }

    // Sliding Window Algorithm
    public static int slidingWindowAlgorithm(int n, int m, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for ( int i=0; i<m; i++ ) sum += arr[i];
        answer = sum;

        for ( int i=m; i<n; i++ ) {
            sum += (arr[i]-arr[i-m]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(maxSales(n, m, arr));
        System.out.println(maxSales2(n, m, arr));
        System.out.println(slidingWindowAlgorithm(n, m, arr));
    }
}
