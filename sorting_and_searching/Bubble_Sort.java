package sorting_and_searching;
import java.util.*;
/*
    2. 버블 정렬

    날짜 : 2023-11-30

    [설명]
    N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
    정렬하는 방법은 버블정렬입니다.


    [입력]
    첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


    [출력]
    오름차순으로 정렬된 수열을 출력합니다.


    [ 풀이 시간 ]
    1. 10:30 ~ 10:35


    [ 공부해야 할 내용 ]
    1. 버블 정렬이란 : 0 ~ 5, 0 ~ 4, 0 ~ 3, 0 ~ 2, 0 ~ 1 이렇게 순차적으로 가면서, 바로 뒤 자료와 비교하며 계속해서 정렬하는 방법이다.

                     버블 정렬은 첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를, … 이런 식으로 (마지막-1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다.
                     1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 자료는 정렬에서 제외되고,
                     2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다.
                     이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.


 */
public class Bubble_Sort {
    public static int[] solution(int n, int[] arr) {
        while ( n > 0 ) {
            for ( int i=0; i<n-1; i++ ) {
                if ( arr[i] > arr[i+1] ) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
            n--;
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
