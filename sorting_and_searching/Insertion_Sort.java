package sorting_and_searching;
import java.util.*;
/*
    3. 삽입 정렬

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
    1. 10:50 ~ 11:07


    [ 공부해야 할 내용 ]
    1. 삽입 정렬이란 : 삽입 정렬은 두 번째 자료부터 시작하여
                     그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다.
                     즉, 두 번째 자료는 첫 번째 자료, 세 번째 자료는 두 번째와 첫 번째 자료, 네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비교한 후 자료가 삽입될 위치를 찾는다.
                     자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.

                     처음 Key 값은 두 번째 자료부터 시작한다.


 */
public class Insertion_Sort {
    public static int[] solution(int n, int[] arr) {

        for ( int i=1; i<n; i++ ) {
            int key = arr[i];
            int j = i - 1;
            while ( j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
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
