package complex_math;
import java.util.*;
/*
    5. 연속된 자연수의 합

    날짜 : 2023-11-01

    [설명]
    N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
    만약 N=15이면
    7+8=15
    4+5+6=15
    1+2+3+4+5=15
    와 같이 총 3가지의 경우가 존재한다.


    [입력]
    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


    [출력]
    첫 줄에 총 경우수를 출력합니다.


    [ 풀이 시간 ]
    1. 10:15 ~ 10:20


    [ 공부해야 할 내용 ]
    1. 연속해서 뭔가를 구해야하거나, 2개의 배열을 가지고 정렬이나 특정 합일경우를 카운트 하는 문제는 Two Pointers Algorithm 을 사용해라.
     - 연속된 값의 합을 구하는 문제에서, 연속되는 갯수가 일정하다면 ( ex. 연속된 3개의 합 ) Slide Window 알고리즘을,
       그게 아니라 갯수가 일정하지 않고, 합이 얼마인지 고정이라면 ( ex. 연속된 수의 합이 5일 경우) two pointers 알고리즘을 사용해라.
     - 2개의 배열로 정렬해서 하나의 배열을 만들거나, 2개의 배열에 공통된 숫자만 정렬해서 하나의 배열에 담는 문제는 two pointers 알고리즘을 사용해라.

    2. two pointers 알고리즘에는 2종류가 있다.
       - 하나는 2개의 배열을 가지고 a배열 b배열을 비교해가며 a 인덱스, b 인덱스를 증가시켜가는 것
       - 다른 하나는 하나의 배열속에서 pS, pE를 지정하여 특정경우에는 pS를 특정 경우에는 pE를 증가시켜가는 방법이 있다.

    3. 수학적 알고리즘 푸는 방법도 공부할 것.
       - 해당 수를 만들기 위해 연속된 수를 몇개 더해야하는지 그 개수를 세면서 푸는 방법이다.
       - 즉, 2개 3개 4개 5개... 이렇게 만드는 방법인데,
         예를 들어 2개로 가능한지 확인하려면, 우리가 원하는 숫자 n에서 -1, -2를 해준 후 남은 n을 2로 나눠서 딱 나눠 떨어지면
         연속된 값이다. 15를 예로들면 15-1 하면 14, 14-2 하면 12가 된다. 그리고 12 % 2 == 0 이므로 연속된 합이 15가 되는 숫자가 된다.
         ( 뺀 숫자에 나눈 숫자 몫을 더한다는 개념이다. 1 + ( 12 / 2 ), 2 + ( 12 / 2 )니까 이건 7 + 8이다. )
         이런 방식으로 3개일 때, 4개일 때, 5개일 때 . . . 해서 n이 0보다 작거나 같아질때까지 진행하면 된다.

 */

public class Sum_Consecutive_Natural_Numbers {

    // 일반적인 풀이 법
    public static int solution(int n) {

        int answer = 0;
        int sum = 0;

        for ( int i=1; i<=((n-1) / 2); i++ ) {
            sum = 0;
            int j = i;
            while ( sum < n ) {
                sum += j;
                j ++;
            }
            if ( sum == n ) answer++;
        }

        return answer;
    }

    public static int twoPointersAlgorithm(int n) {

        int answer = 0;
        int sum = 0;
        int pS = 1;
        int m = (n-1)/2;

        for ( int pE = 1; pS <= m; pE ++ ) {
            sum += pE;
            if ( sum == n ) answer ++;
            while ( sum >= n ) {
                sum -= pS;
                pS ++;
                if ( sum == n ) answer ++;
            }
        }
        return answer;
    }

    // 수학적 알고리즘을 이용해서 푸는 방법
    public static int mathAlgorithm(int n) {
        int answer = 0;
        int cnt = 1;

        n--;
        while ( n > 0 ) {
            cnt ++;
            n -= cnt;
            if ( n % cnt == 0 ) answer ++;
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(twoPointersAlgorithm(n));
    }
}
