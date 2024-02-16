package dynamic;
import java.util.*;
/*
    3. 최대부분증가수열 ( LIS )

    날짜 : 2024-02-16

    [설명]
    N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
    예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
    길이가 5인 최대 부분 증가수열을 만들 수 있다.


    [입력]
    첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,
    둘째 줄은 N개의 입력데이터들이 주어진다.


    [출력]
    첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.


    [ 풀이 시간 ]
    총 풀이시간 1004 ~ 1022
        - 문제 분석 ( 1004 ~ 1012 )
        - 손 코딩 ( x )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 1012 ~ 1016 )
        - 코드 구현 ( 1017 ~ 1022 )


    [ 문제 풀이 순서 ]
    - arr 배열에는 문제에서 제시한 숫자를, 그리고 그 배열의 크기와 동일한 dy 라는 배열을 만든다.
    - dy 에는 0부터 해당 dy[?] 까지 작은수에서 큰수로 만들 수 있는 부분수열의 갯수를 넣는다.
    - 그걸 구하는 방법은, 해당 arr[?] 보다 앞에 있는 수들을 비교하면서 arr[?] 보다 작은 수 중 가장 큰 수를 찾아야 한다.
    - 그 수를 만들기 위한 부분수열의 갯수 + 1을 해주면, arr[?] 에 대한 부분수열의 갯수인 dy[?] 값을 구할 수 있다.
    - 이 때 arr[?] 보다 작은 수가 없다면, 1이 들어가야 하므로, int max = 0 을 Default 값으로 지정해두어야 한다.
    - 또한 첫번째 수와 두 번째 수는 무조건 방법이 1개밖에 없으므로, arr[0], arr[1] 은 1을 미리 입력해두어도 된다.

 */
public class Maximum_Partially_Increasing_Sequence {
    public static int solution(int[] arr, int N) {
        int answer = 0;
        int[] dy = new int[N];
        dy[0] = 1;
        for ( int i=1; i<N; i++ ) {
            int max = 0;
            for ( int j=0; j<i; j++ ) {
                if ( arr[i] > arr[j] && dy[j] > max ) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for ( int i=0; i<N; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(arr, N));
    }
}
