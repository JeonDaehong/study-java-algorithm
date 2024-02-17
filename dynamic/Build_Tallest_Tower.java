package dynamic;
import java.util.*;
/*
    4. 가장 높은 탑 쌓기

    날짜 : 2024-02-17

    [설명]
    밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
    아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
    (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
    (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
    (조건3) 벽돌들의 높이는 같을 수도 있다.
    (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
    (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.


    [입력]
    입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
    둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
    각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.


    [출력]
    첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.


    [ 풀이 시간 ]
    총 풀이시간 1130 ~ 1207
        - 문제 분석 ( 1130 ~ 1145 )
        - 손 코딩 ( 1146 ~ 1152 )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 1153 ~ 1158 )
        - 코드 구현 ( 1159 ~ 1207 )


    [ 문제 풀이 순서 ]
    - LIS 방식으로 문제를 풀 수 있다.
    - 먼저 넓이와, 무게를 기준으로 그것보다 작은것만 올려야 하기 때문에 둘 중 하나인 넓이의 내림차순으로 정렬해준다.
    - 이후 무게를 가지고 LIS 방식으로 비교하면 된다.
    - dy 배열을 하나 만들어서, 본인 이전의 벽돌의 무게를 비교하고 ( 어차피 넓이 내림차순이라 넓이는 비교 안해도 됨. )
    - 앞의 벽돌 무게 중, 지금 자신의 벽돌 무게보다 큰 것 중, 높이가 가장 높은 것을 구하여, 그 높이와 내 벽돌의 높이를 더한 값을 dy[?] 에 입력한다.
    - 최종적으로 dy[ ] 배열 중 가장 큰 값을 return 해주면 된다.

 */
class Brick implements Comparable<Brick> {
    public int s, h, w;
    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}
public class Build_Tallest_Tower {

    static int[] dy;

    public static int solution(List<Brick> bricks, int N) {
        int answer = 0;
        Collections.sort(bricks); // 재정의 한 대로 정렬하기
        dy[0] = bricks.get(0).h;
        for ( int i=1; i<N; i++ ) {
            Brick brick = bricks.get(i);
            int max_h = 0;
            for ( int j=0; j<i; j++ ) {
                Brick tmpBrick = bricks.get(j);
                if ( tmpBrick.w > brick.w && dy[j] > max_h ) {
                    max_h = dy[j];
                }
                dy[i] = max_h + brick.h;
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Brick> bricks = new ArrayList<>();
        dy = new int[N];
        for ( int i=0; i<N; i++ ) {
            bricks.add(new Brick(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
        System.out.println(solution(bricks, N));
    }
}
