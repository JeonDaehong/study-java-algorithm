package sorting_and_searching;
import java.util.*;
/*
    7. 좌표 정렬

    날짜 : 2023-12-12

    [설명]
    N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
    정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.


    [입력]
    첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
    두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.


    [출력]
    N개의 좌표를 정렬하여 출력하세요.


    [ 풀이 시간 ]
    1. 09:35 ~ 09:50


    [ 공부해야 할 내용 ]
    1. 2차원 배열 정렬해주는 코드는 아래 코드를 외우면 좋다.

    // 오름차순 정렬
    Arrays.sort(arr, (o1,o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

    // 내림차순 정렬
    Arrays.sort(arr, (o1,o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));

 */

public class Coordinate_Alignment {

    public static int[][] solution(int n, int[][] arr) {
        Arrays.sort(arr, (o1,o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for ( int i=0; i<n; i++ ) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        for ( int[] x : solution(n, arr) ) {
            System.out.println(x[0] + " " + x[1]);
        }
    }

}
