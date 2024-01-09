package dfs_bfs;
import java.util.*;
/*
    6. 순열 구하기

    날짜 : 2024-01-08

    [설명]
    10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.


    [입력]
    첫 번째 줄에 자연수 N(3<=N<=) 과 M(2<=M<=N) 이 주어집니다.
    두 번째 줄에는 N개의 자연수가 오름차순으로 주어집니다.


    [출력]
    첫 번째 줄에 결과를 출력합니다.
    출력 순서는 사전순으로 오름차순으로 출력합니다.


    [ 풀이 시간 ]
    1. 11:21 ~ 11:39


    [ 풀이 과정 ]
    1. 배열을 잘 활용해야 한다.
    2. 값을 넣는 배열과, 실제 답을 출력하는 배열, 그리고 중복이 안되기 때문에 체크해야하는 배열까지 총 3개의 배열을 활용하여야 한다.


 */
public class Finding_Permutations {
    static int N, M;
    static int[] answerArr;
    static boolean[] checkArr;
    public static void DFS(int L, int[] arr) {
        if ( L == M ) {
            System.out.println(answerArr[0] + " " + answerArr[1]);
        } else {
            for ( int i=0; i<arr.length; i++ ) {
                if ( !checkArr[i] ) {
                    checkArr[i] = true;
                    answerArr[L] = arr[i];
                    DFS(L + 1, arr);
                    checkArr[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        int[] arr = new int[N];
        answerArr = new int[M];
        checkArr = new boolean[N];
        for ( int i=0; i<N; i++ ) {
            arr[i] = scan.nextInt();
        }
        DFS(0, arr);
    }

}
