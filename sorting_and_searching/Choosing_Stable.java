package sorting_and_searching;
import java.util.Arrays;
import java.util.Scanner;

/*
    10. 마구간 정하기 ( 결정 알고리즘 )

    날짜 : 2023-12-15

    [설명]
    N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
    현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
    가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
    C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.


    [입력]
    첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
    둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.


    [출력]
    첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.


    [ 풀이 시간 ]
    1. 10:30 ~ 10:57 ( 풀이 성공 )


    [ 공부해야 할 내용 ]
    1. Stream 형식 공부할 것. Arrays.stream(arr).max().getAsInt(); 나, Arrays.stream(arr).sum(); 이런거는 꼭 공부할 것.
    2. 이진 탐색은 정렬된 리스트에서 검색 범위를 줄여 나가면서 검색 값을 찾는 알고리즘이다.
    3. lt 와 rt 가 꼭 배열 사이의 값이 되는게 아니다. 내가 풀려고 하는 답과 관련된 범위를 지정해주어야 한다.

 */
public class Choosing_Stable {

    public static int count(int[] arr, int distance) {
        int ep = arr[0];
        int count = 1;
        for ( int i=1; i<arr.length; i++ ) {
            if ( arr[i] - ep >= distance ) {
                ep = arr[i];
                count ++;
            }
        }
        return count;
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1; // 최소 거리
        int rt = arr[n-1]; // 최대 거리
        while ( lt <= rt ) {
            int mid = ( lt + rt ) / 2;
            if ( count(arr, mid) >= c ) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }

        System.out.println(solution(n, c , arr));
    }

}
