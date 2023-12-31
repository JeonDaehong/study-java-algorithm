package array;
import java.util.*;
/*
    10. 봉우리

    날짜 : 2023-10-26

    [설명]
    지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
    각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
    격자의 가장자리는 0으로 초기화 되었다고 가정한다.
    만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
    -------------
    0 0 0 0 0 0 0
    0 5 3 7 2 3 0
    0 3 7 1 6 1 0
    0 7 2 5 3 4 0
    0 4 3 6 4 1 0
    0 8 7 3 5 2 0
    0 0 0 0 0 0 0
    -------------


    [입력]
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


    [출력]
    봉우리의 개수를 출력하세요.


    [ 풀이 시간 ]
    1. 10:15 ~ 10:29
    
    
    [ 공부해야 할 내용 ]
    1. int[] dx, int[] dy 를 활용한 풀이 방법 공부


 */
public class Peaks {
    public static int peaksCount(int count, int[][] peaksArr) {
        int peaksCount = 0;
        for ( int i = 1; i <= count; i ++ ) {
            for ( int j = 1; j <= count; j ++ ) {
                if ( peaksArr[i][j] > peaksArr[i-1][j]
                        && peaksArr[i][j] > peaksArr[i][j-1]
                        && peaksArr[i][j] > peaksArr[i+1][j]
                        && peaksArr[i][j] > peaksArr[i][j+1] ) {
                    peaksCount ++;
                }
            }
        }
        return peaksCount;
    }

    // 정석적인 풀이 방법 ( 꼭 4방향만이 아닐 수 있으므로, if문만으로 하는건 바람직하지 못하다. )
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static int peaksCount2(int count, int[][] peaksArr) {
        int peaksCount = 0;
        for ( int i = 1; i <= count; i ++ ) {
            for ( int j = 1; j <= count; j ++ ) {
                boolean check = true;
                for (int k=0; k<dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = i + dy[k];
                    if ( peaksArr[i][j] <= peaksArr[nx][ny] ) {
                        check = false;
                        break;
                    }
                }
                if ( check ) peaksCount ++;
            }
        }
        return peaksCount;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[][] peaksArr = new int[count+2][count+2];
        for (int i=1; i<=count; i++) {
            for (int j=1; j<=count; j++) {
                peaksArr[i][j] = scan.nextInt();
            }
        }
        System.out.println(peaksCount(count, peaksArr));
    }
}
