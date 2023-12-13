package sorting_and_searching;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
    8. 이분 검색 ( 이진 탐색 )

    날짜 : 2023-12-13

    [설명]
    임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
    이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.


    [입력]
    첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
    두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.


    [출력]
    첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.


    [ 풀이 시간 ]
    1. 09:10 ~ 09:27


    [ 공부해야 할 내용 ]
    1. 이진 탐색이란 정렬된 배열의 가운데부터 시작하여 내가 구하려는 수와 비교해가며 탐색하는 방법이다.

 */


public class Binary_Search {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;

        while (lt <= rt) {
            int mid = ( lt + rt ) / 2;
            if ( arr[mid] == m ) {
                answer = mid + 1;
                break;
            }
            else if ( arr[mid] < m ) {
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
        int m = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

}
