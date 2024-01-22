package greedy;
import java.util.*;
/*
    2. 회의실 배정

    날짜 : 2024-01-20

    [설명]
    한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
    각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
    단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.


    [입력]
    첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
    이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
    회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.


    [출력]
    첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.


    [ 풀이 시간 ]
    1. 21:59 ~ 22:09


    [ 풀이 과정 ]
    - [ 1번 방식 ]
    - 회의 시간을 시작 시간 기준으로 역순으로 정렬 한다.
    - 예를들어 E D C B A 순이 된다면, E의 시작시간을 tmp 변수에 저장한다.
    - D 의 끝나는 시간이 E 의 시작시간보다 작거나 같으면, answer 을 ++ 해주고,
    - D 의 시작시간을 tmp 변수에 저장한다.
    - [ 2번 방식 ]
    - 반대로, 회의 끝나는 시간을 기준으로 정순으로 정렬한 후,
    - tmp 에는 끝나는 시간을 저장하고
    - 다음 회의 시작시간이, 이전 회의 끝나는 시간보다 크거나 같으면,
    - answer ++ 을 하고,
    - tmp 에 다음 회의가 끝나는 시간을 저장하는 방식이 있다.
    - 단 2번 방식의 경우에는, 회의가 끝나는 시간이 같을 수 있으므로
    - 회의 끝나는 시간이 같다면, 시작시간 기준으로 정순으로 정렬하는 로직을 추가해주어야 한다.

 */
class Meeting implements Comparable<Meeting>{
    int startNum, endNum;
    public Meeting(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public int compareTo(Meeting o) {
        return o.startNum - this.startNum;
    }
}
public class MeetingRoom_Assignment {
    public static int solution(List<Meeting> meetingList, int N) {
        int answer = 0;
        int startLimitTime = Integer.MAX_VALUE;
        for ( Meeting meeting : meetingList ) {
            if ( meeting.endNum <= startLimitTime ) {
                startLimitTime = meeting.startNum;
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Meeting> meetingList = new ArrayList<>();
        for ( int i=0; i<N; i++ ) {
            meetingList.add(new Meeting(scan.nextInt(), scan.nextInt()));
        }
        Collections.sort(meetingList);
        System.out.println(solution(meetingList, N));
    }
}
