package dynamic;
import java.util.*;
/*
    6. 가장 높은 탑 쌓기

    날짜 : 2024-02-23


    [설명]
    이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
    각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
    제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
    (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)


    [입력]
    첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
    두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.


    [출력]
    첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.


    [ 풀이 시간 ]
    총 풀이시간 0930 ~ 1002
        - 문제 분석 ( 0930 ~ 0945 )
        - 손 코딩 ( 0945 ~ 0952 )
        - 슈도코드 [ 원초적 설계 -> 알고리즘 ] ( 0953 ~ 0958 )
        - 코드 구현 ( 0958 ~ 1002 )


    [ 문제 풀이 중요 부분 ]
    - 냅색 알고리즘에서 우리가 생각해야 하는 변수가 여러개라면, 순차적으로 앞에서부터 계산해주는 것이 좋다.
    - 그러나 이 문제처럼 점수와 시간으로만 단순하게 되어있는 경우 시간 만큼 dy[ ] 를 만들어주고
    - 뒤에서부터 역순으로 계산해주면 편하게 계산할 수 있다.

 */
public class Maximum_Score {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] dy = new int[m+1];
        for ( int i=0; i<n; i++ ) {
            int ps = scan.nextInt();
            int pt = scan.nextInt();
            for ( int j=m; j>=pt; j-- ) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
            System.out.println("[" + (i+1) + "]");
            for ( int j=1; j<=m; j++ ) {
                System.out.print(dy[j] + " ");
            }
            System.out.println();
        }
        System.out.println(dy[m]);
    }
}
