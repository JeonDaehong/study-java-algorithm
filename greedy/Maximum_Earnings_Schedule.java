package greedy;
import java.util.*;
/*
    4. 최대 수입 스케쥴

    날짜 : 2024-01-23

    [설명]
    현수는 유명한 강연자이다.
    N개이 기업에서 강연 요청을 해왔다.
    각 기업은 D일 안에 와서 강연을 해 주면 M 만큼의 강연료를 주기로 했다.
    각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
    단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


    [입력]
    첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


    [출력]
    첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.


    [ 풀이 시간 ]
    1. 09:25 ~ 10:24


    [ 풀이 과정 ]
    - PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        - 큰 값을 우선순위로 저장하는 우선순위 비선형 큐이다.
        - PriorityQueue<Integer> pQ = new PriorityQueue<>(); 이렇게하면, 작은 값을 우선으로 저장한다.
    - List 를 만들어서 시간, 돈이 있는데, 시간을 내림차순으로 정렬한다.
    - 가장 큰 날짜를 maxDay 라는 변수를 선언하여 저장한다.
    - for ( i = maxDay; i >= 1; i-- ) 를 활용하여 날짜를 역순으로 반복문을 돌린다.
    - 그 안에서 강연 갯수 N 만큼 또 배열을 돌린다.
        - 이 때, 중요한 것은,
        - for ( int j=0; j<N; j++ ) 이 아니다.
        - j 는 i보다 바깥에 0으로 해놓고,
        - for ( ; j<N; j++ ) 로 해서
        - 강의 갯수만큼은 1번만 돌고, 그 안에서 time 이 i 보다 크거나 같은거만 queue에 offer 할 수 있게 해야하는게 중요하다.
    - PriorityQueue 를 활용하여, 현재 날짜 ( i ) 에 가능한 강의를 PriorityQueue 에 넣는다.
    - List 에 저장된 시간이 i 보다 작을경우 강의를 할 수 없으니, break 를 해준다.
    - D 에 저장된 날짜는 그 날짜 내에 아무때나 오면 강연이 가능하다는 의미이다.
        - 즉, 내림차순이므로, poll 되지 않는 이상 처음 저장된건 끝까지 강연이 가능하다.
        - 그래서 queue 를 clear 하지 않는다.
 */
class Lecture implements Comparable<Lecture>{
    int m, t;
    public Lecture(int m, int t) {
        this.m = m;
        this.t = t;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.t - this.t;
    }
}
public class Maximum_Earnings_Schedule {
    public static int solution(List<Lecture> lectureList, int N, int maxDay) {
        int answer = 0;
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for ( int i=maxDay; i>=1; i-- ) {
            for ( ; j<N; j++ ) {
                if ( lectureList.get(j).t<i ) break; // 강연 할 수 없는 날짜
                pQ.offer( lectureList.get(j).m);
            }
            if ( ! pQ.isEmpty() ) {
                answer += pQ.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int maxDay = Integer.MIN_VALUE;
        List<Lecture> lectureList = new ArrayList<>();
        for ( int i=0; i<N; i++ ) {
            int m = scan.nextInt();
            int t = scan.nextInt();
            lectureList.add(new Lecture(m, t));
            if ( maxDay < t ) maxDay = t;
        }
        Collections.sort(lectureList);
        System.out.println(solution(lectureList, N, maxDay));
    }
}
