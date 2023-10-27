package array;
import java.util.*;
/*
    9. 격자판 최대합

    날짜 : 2023-10-26

    [설명]
    5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

    --------------
    10 13 10 12 15
    12 39 30 23 11
    11 25 50 53 15
    19 27 29 37 27
    19 13 30 13 19
    --------------

    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


    [입력]
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


    [출력]
    최대합을 출력합니다.


    [ 풀이 시간 ]
    1. 09:40 ~ 09:53


    [ 공부해야 하는 내용 ]
    1. 정석 풀이 방법 외우기

 */
public class Grid_Max_Sum {

    public static int widthSum(int num, int count, int[][] gridArr) {
        int sum = 0;
        for ( int i=0; i<count; i++) {
            sum += gridArr[num][i];
        }
        return sum;
    }

    public static int heightSum(int num, int count, int[][] gridArr) {
        int sum = 0;
        for ( int i=0; i<count; i++) {
            sum += gridArr[i][num];
        }
        return sum;
    }

    public static int diagonalSum(int count, int[][] gridArr) {
        int sum = 0;
        for ( int i=0; i<count; i++) {
            sum += gridArr[i][i];
        }
        return sum;
    }

    public static int reverseDiagonalSum(int count, int[][] gridArr) {
        int sum = 0;
        for ( int i=count-1; i>=0; i--) {
            sum += gridArr[i][i];
        }
        return sum;
    }

    public static int gridMaxSum(int count, int[][] gridArr) {

        int maxSum = Integer.MIN_VALUE;
        int tmp = 0;

        for (int i=0; i<count; i++) {
            tmp = Math.max(widthSum(i, count, gridArr),heightSum(i, count, gridArr));
            if (maxSum < tmp) maxSum = tmp;
        }

        tmp = Math.max(diagonalSum(count, gridArr),reverseDiagonalSum(count, gridArr));
        if (maxSum < tmp) maxSum = tmp;

        return maxSum;
    }

    // 정석적인 메서드
    public static int gridMaxSum2(int count, int[][] gridArr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for ( int i=0; i<count; i++ ) {
            sum1 = sum2 = 0;
            for ( int j=0; j<count; j++ ) {
                sum1 += gridArr[i][j];
                sum2 += gridArr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for (int i=0; i<count; i++) {
            sum1 += gridArr[i][i];
            sum2 += gridArr[i][count-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[][] gridArr = new int[count][count];
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                gridArr[i][j] = scan.nextInt();
            }
        }
        System.out.println(gridMaxSum(count, gridArr));
    }
}
