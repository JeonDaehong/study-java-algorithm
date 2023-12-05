package sorting_and_searching;
import java.util.*;
/*
    5. 중복 확인

    날짜 : 2023-12-05

    [설명]
    현수네 반에는 N명의 학생들이 있습니다.
    선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
    만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
    N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
    두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.


    [출력]
    첫 번째 줄에 D 또는 U를 출력한다.


    [ 풀이 시간 ]
    1. 10:20 ~ 10:25

    [ 공부해야 할 내용 ]
    1. 중복 확인에는 Map의 getOrDefault 메서드를 활용하는 것이 좋다.

 */
public class Double_Check {
    public static char solution(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i : arr ) {
           map.put(i, map.getOrDefault(i, 0) + 1);
           if ( map.get(i) > 1) return 'D';
        }
        return 'U';
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.println(solution(n, arr));
    }
}
