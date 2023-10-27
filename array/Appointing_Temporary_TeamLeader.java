package array;
import java.util.*;
/*
    11. 임시반장 정하기

    날짜 : 2023-10-26

    [설명]
    김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
    김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
    그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
    그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
    예를 들어 학생 수가 5명일 때의 표를 살펴보자.

                1학년   2학년   3학년   4학년   5학년
    1번 학생        2      3       1      7      3
    2번 학생        4      1       9      6      8
    3번 학생        5      5       2      4      4
    4번 학생        6      5       2      6      7
    5번 학생        8      4       2      2      2

    위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
    2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
    같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
    이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
    각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.


    [입력]
    첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
    둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
    주어지는 정수는 모두 1 이상 9 이하의 정수이다.


    [출력]
    첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
    단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.


    [ 풀이 시간 ]
    1. 11:00 ~ 11:19 ( Runtime Error : 시간 초과 )
    2. 11:35 ~ 11:37 ( 입력 받는 부분 수정 )


    [ 공부해야 할 내용 ]
    1. Scanner로 입력을 받을 때, 불필요한 입력을 받지 않게끔 크기를 잘 조절해야 한다.
       예를 들어, 5학년까지 밖에 없으므로,
       iArr[count][5]; 까지만 하면 되는데
       iArr[count][count]; 이렇게 해버리면, iArr[100][100]; 이렇게 될 수도 있어서
       시간 초과 Runtime Error가 생길 수 있다.
    2. break;가 실제 서비스에서는 많이 쓰면 안좋을 수 있지만,
       알고리즘 문제에서는 중복 되는 부분을 없애기 위해서라면 continue; 와 break; 를 잘 활용해야 한다.
       해당 문제에서도 친구와 이미 같은 반이었던 적이 1학년때 있다면 2 3 4 5학년에 같은 반이었었는지는 굳이 확인하지 않아도 된다.
       그럴 경우 불필요한 연산 시간을 막기 위해 break;를 해주면 된다.
       그리고 자기 자신일 경우는 계산하지 않아도 되므로 continue; 도 활용하였다.


 */
public class Appointing_Temporary_TeamLeader {

    public static int teamLeaderSelect(int count, int[][] iArr) {

        final int GRADE_COUNT = 5;
        int leader = -1;
        int maxFriends = Integer.MIN_VALUE;

        // i == 나
        // j == 학년
        // k == 몇 번 학생
        for ( int i=0; i<count; i++ ) {
            int thisFriends = 0;
            for ( int j=0; j<count; j++ ) {
                if (i == j) continue;
                for ( int k=0; k<GRADE_COUNT; k++ ) {
                    if ( iArr[i][k] == iArr[j][k] ) {
                        thisFriends ++;
                        break;
                    }
                }
            }
            if (maxFriends < thisFriends) {
                maxFriends = thisFriends;
                leader = i+1;
            }
        }

        return leader;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[][] iArr = new int[count][5];
        for (int i=0; i<count; i++) {
            for (int j=0; j<5; j++) {
                iArr[i][j] = scan.nextInt();
            }
        }
        System.out.println(teamLeaderSelect(count, iArr));
    }
}
