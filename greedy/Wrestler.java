package greedy;
import java.util.*;

/*
    1. 씨름 선수

    날짜 : 2024-01-19

    [설명]
    현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
    현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
    현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
    “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
    존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
    N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.


    [입력]
    첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
    두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.
    각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.


    [출력]
    첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.


    [ 풀이 시간 ]
    1. 10:31 ~ 10:51


    [ 풀이 과정 ]
    - 그리디 알고리즘이라는 것은, 최적의 방법을 찾는 알고리즘이다.
    - 이번 문제에서는 키와 몸무게를 모두 비교해서, 전부 낮은 사람을 제외시키는 것인데,
    - Comparable<> 을 구현하여, compareTo 메서드를 재정의 하는 방법으로
    - 먼저 키와 몸무게 둘 중 하나를 내림차순으로 정렬한다.
    - 그 후, 남은 하나만 비교하며 현재까지 나온 크기중 가장 큰 크기를 저장하고,
    - 그것과 비교하며 더 큰 수가 나올 수록 count 를 올려주면 된다.


 */
class Body implements Comparable<Body> {

    int weight, height;

    public Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Body o) {
        return o.height - this.height; // 내림차순
        // return this.height - o.height // 오름차순
    }

}
public class Wrestler {
    public static int solution(int N, List<Body> bodyList) {
        int count = 0;
        int maxWeight = Integer.MIN_VALUE;
        Collections.sort(bodyList); // 재정의 된 compareTo 방식으로 정렬이 됨.
        for ( Body body : bodyList ) {
            if ( maxWeight < body.weight ) {
                count ++;
                maxWeight = body.weight;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Body> bodyList = new ArrayList<>();
        for ( int i=0; i<N; i++ ) {
            bodyList.add(new Body(scan.nextInt(), scan.nextInt()));
        }
        System.out.println(solution(N, bodyList));
    }

}
