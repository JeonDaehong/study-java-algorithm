package dfs_bfs;
import java.util.*;
/*
    4. 중복순열 구하기

    날짜 : 2024-01-04

    [설명]
    1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하시오.


    [입력]
    첫 번째 줄에 자연수 N(3<=N<=10) 과 M(2<=M<=N) 이 주어집니다.


    [출력]
    첫 번째 줄에 결과를 출력합니다.
    출력 순서는 사전순으로 오름차순으로 출력합니다.


    [ 풀이 시간 ]
    1. 09:28 ~ 09:43


    [ 풀이 과정 ]
    1. 일반적인 부분집합 구하는 문제와 같다.
    2. 그러나 중복이 가능하므로, for 문을 이용해주어 배열에 저장해주는 방법이 좋다.
    3. 스택을 그려보면 이해하기가 편한데, for 문 덕분에 1 1, 1 2, 1 3 . . . 이렇게 다 한 번씩 돌 수 있다.


 */
public class Finding_Duplicate_Permutations {
    static int N, M;
    static int[] ch;
    public static void DFS(int L) {
        if ( L == M ) {
            for ( int x : ch ) System.out.print(x + " ");
            System.out.println();
        } else {
            for ( int i=1; i<=N; i++ ) {
                ch[L] = i;
                DFS(L + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        ch = new int[M];
        DFS(0);
    }
}
