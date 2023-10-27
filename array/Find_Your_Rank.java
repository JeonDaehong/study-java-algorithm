package array;
import java.util.*;
/*
    8. 등수 구하기

    날짜 : 2023-10-26

    [설명]
    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
    같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
    즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


    [입력]
    첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


    [출력]
    입력된 순서대로 등수를 출력한다.


    [ 풀이 시간 ]
    1. 09:25 ~ 09:29


 */
public class Find_Your_Rank {

    public static int[] findRank(int stuCount, int[] scoreArr) {
        int[] rankArr = new int[stuCount];
        for ( int i=0; i<stuCount; i++ ) {
            int num = 1;
            for (int j = 0; j < stuCount; j++) {
                if (scoreArr[i] < scoreArr[j]) num++;
            }
            rankArr[i] = num;
        }
        return rankArr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stuCount = scan.nextInt();
        int[] scoreArr = new int[stuCount];
        for ( int i=0; i<stuCount; i++ ) {
            scoreArr[i] = scan.nextInt();
        }
        for ( int rank : findRank(stuCount, scoreArr) ) {
            System.out.print(rank + " ");
        }
    }
}
