package dynamic;
import java.util.*;
/*
    2. 돌다리 건너기

    날짜 : 2024-02-15

    [설명]
    철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
    철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
    철수가 개울을 건너는 방법은 몇 가지일까요?


    [입력]
    첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.


    [출력]
    첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.


    [ 풀이 시간 ]
    총 풀이시간 1009 ~ 1012
        - 문제 분석 ( 1009 ~ 1010 )
        - 손 코딩 ( x )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 1010 ~ 1011 )
        - 코드 구현 ( 1011 ~ 1012 )


    [ 문제 풀이 순서 ]
    - 계단 오르기 문제와 유사한 문제이다.
    - 그러나, 돌 다리 건너기는 맨 마지막 땅을 밟아야 하기 때문에
    - 주어진 돌의 갯수 + 1 을 더 해주어야 한다.

 */
public class Cross_Stone_Bridge {

    public static int solution(int N) {
        int[] arr = new int[N+2]; // 맨 마지막 땅을 밟아야 하기 때문에 원래 공식 + 1을 더 해준다.
        arr[1] = 1;
        arr[2] = 2;
        for ( int i=3; i<=N+1; i++ ) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[N+1];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println(solution(N));
    }
}
