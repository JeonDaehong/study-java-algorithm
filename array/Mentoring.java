package array;
import java.util.*;
/*
    12. 멘토링

    날짜 : 2023-10-27

    [설명]
    현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
    멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
    선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
    만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
    M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
    두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
    만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


    [출력]
    첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.


    [ 풀이 시간 ]
    1. 10:50 ~ 11:20 ( 문제풀이 실패 )
    2. 13:15 ~ 13:25 ( 공부 후 문제 풀이 : 성공 )


    [ 공부해야 할 내용 ]
    1. 문제의 접근을 잘 해야한다.


 */

public class Mentoring {
    public static int mentoring(int stuCount, int testCount, int[][] iArr) {

        int answer = 0;

        for ( int i=1; i<=stuCount; i++ ) {              // 멘토x멘티의 경우의 수는 stuCount x stuCount 이므로, 2중 for문을 걸어준다. ( 등수 )
            for ( int j=1; j<=stuCount; j++ ) {
                int cnt = 0;                             // A가 B보다 잘 본 시험의 횟수를 카운팅할 변수 선언
                for ( int k=0; k<testCount; k++ ) {      // 테스트 개수
                    int pi = 0, pj = 0;
                    for ( int l=0; l<stuCount; l++ ) {
                        if ( iArr[k][l] == i ) pi = l;   // 멘토의 등수 저장
                        if ( iArr[k][l] == j ) pj = l;   // 멘티의 등수 저장
                    }
                    if ( pi < pj ) cnt ++;  // 멘토가 멘티보다 등수가 높으면 cnt ++;
                }
                if ( cnt == testCount ) answer ++; // 모든 시험에서 멘토가 멘티보다 등수가 높으면 answer ++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stuCount = scan.nextInt();
        int testCount = scan.nextInt();
        int[][] iArr = new int[testCount][stuCount];
        for (int i=0; i<testCount; i++) {
            for (int j=0; j<stuCount; j++) {
                iArr[i][j] = scan.nextInt();
            }
        }
        System.out.println(mentoring(stuCount, testCount, iArr));
    }
}
