package greedy;
import java.util.*;
/*
    3. 결혼식

    날짜 : 2024-01-22

    [설명]
    현수는 다음 달에 결혼을 합니다.
    현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
    피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
    각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
    현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
    만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.


    [입력]
    첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
    두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
    시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.


    [출력]
    첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.


    [ 풀이 시간 ]
    1. 10:10 ~ 10:32


    [ 풀이 과정 ]
    - 시간을 기준으로 정렬해준다.
    - 시간이 같을 경우, status 가 s -> e 순으로 정렬해준다.
    - 여기서 s 는 참석 시작 시간이고, e 는 참석 종료 시간이다.
    - 즉, 1명에 대하여 s 인 경우와 e 인 경우 2가지를 모두 하나의 리스트에 넣어놓는 것이다.
    - 그렇게 해서, s 가 나오면 +1, e 가 나오면 -1 을 해주어,
    - 가장 count 가 높은걸 반환해주면 된다.

 */
class Time implements Comparable<Time> {
    int time;
    char status;
    public Time (int time, char status) {
        this.time = time;
        this.status = status;
    }
    @Override
    public int compareTo(Time o) {
        if ( this.time == o.time ) return this.status - o.status;
        return this.time - o.time;
    }
}
public class Wedding_Ceremony {
    public static int solution(List<Time> participants, int N) {
        int answer = Integer.MIN_VALUE;
        int tmpCount = 0;
        for ( Time participant : participants ) {
            if ( participant.status == 's' ) tmpCount ++;
            else tmpCount --;
            answer = Math.max(answer, tmpCount);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Time> participants = new ArrayList<>();
        for ( int i=0; i<N; i++ ) {
            int st = scan.nextInt();
            int et = scan.nextInt();
            participants.add(new Time(st, 's'));
            participants.add(new Time(et, 'e'));
        }
        Collections.sort(participants);
        System.out.println(solution(participants, N));
    }
}
