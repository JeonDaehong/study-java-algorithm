package hash;
import java.util.*;
/*
    3. 매출액의 종류

    날짜 : 2023-11-07 / 2023-11-09

    [설명]
    현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
    각 구간별로 구하라고 했습니다.
    만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
    20 12 20 10 23 17 10
    각 연속 4일간의 구간의 매출종류는
    첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
    두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
    세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
    네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
    N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
    매출액의 종류를 출력하는 프로그램을 작성하세요.



    [입력]
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


    [출력]
    첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.


    [ 풀이 시간 ]
    1. 08:50 ~ 09:50 ( 풀이 실패 다시 풀어볼 것 )
    2. 08:58 ~ 09:08 ( 풀이 성공, 그러나 괄호 잘 볼 것 !! 0


    [ 공부해야 할 내용 ]
    1. HashMap 과 Sliding Window 알고리즘을 합친 풀이 방법을 잘 공부하고 복습하고 숙지할 것.


 */
public class Sales_Type {

    public static List<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for ( int rt = k-1; rt < n; rt ++ ) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answerList.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if ( map.get(arr[lt]) == 0 ) map.remove(arr[lt]);
            lt ++;
        }

        return answerList;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        for ( int i : solution(n, k, arr)) System.out.print(i + " ");
    }

}
