package complex_math;
import java.util.*;
/*
    6. 최대 길이 연속부분수열 (복합적 문제)

    날짜 : 2023-11-04

    [설명]
    0과 1로 구성된 길이가 N인 수열이 주어집니다.
    여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
    여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
    만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
    1 1 0 0 1 1 0 1 1 0 1 1 0 1
    여러분이 만들 수 있는 1이 연속된 연속부분수열은
    1 1 0 0 [ 1 1 '1' 1 1 '1' 1 1 ]
    이며 그 길이는 8입니다.


    [입력]
    첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
    두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.


    [출력]
    첫 줄에 최대 길이를 출력하세요.


    [ 풀이 시간 ]
    1. 08:45 ~ 09:10


    [ 공부해야 할 내용 ]
    1. 이것도 two points Algorithm 인데, 머리를 좀 잘 써야된다. 공식과 원리를 외우자


 */
public class Max_Length_Continuous_Subsequence {

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0; // k에 대한 카운트
        int pS = 0;
        for ( int pE=0; pE<n; pE++ ) {
            if ( arr[pE] == 0 ) cnt++;
            while(cnt>k) {
                if ( arr[pS] == 0 ) cnt--;
                pS++;
            }
            answer = Math.max(answer, pE-pS+1);
        }
        return answer;
    }

    public static void main(String[] args){
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
