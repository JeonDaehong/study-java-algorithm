package sorting_and_searching;
import java.util.*;
/*
    1. 선택 정렬

    날짜 : 2023-11-30

    [설명]
    N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
    정렬하는 방법은 선택정렬입니다.


    [입력]
    첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


    [출력]
    오름차순으로 정렬된 수열을 출력합니다.


    [ 풀이 시간 ]
    1. 10:03 ~ 10:20


    [ 공부해야 할 내용 ]
    1. 선택 정렬이란 : 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고,
                     두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여,
                     그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다


 */
public class Selection_Sort {
    public static int[] solution(int n, int[] arr) {
        for ( int i=0; i<n-1; i++ ) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for ( int j=i+1; j<n; j++ ) {
                if ( min > arr[j] ) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            if ( arr[i] > min ) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[]arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        for ( int i : solution(n, arr) ) {
            System.out.print(i + " ");
        }
    }
}
