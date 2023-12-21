package basic;

import java.util.Scanner;

/*
    6. 부분 집합 구하기 ( DFS )

    날짜 : 2023-12-21

    [설명]
    자연수 N이 주어지면, 1부터 N까지의 원소를 가즌ㄴ 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.


    [입력]
    첫 줄은 총 항수 N(1<=N<=10)이 주어집니다.


    [출력]
    첫 줄부터 각 줄에 하나씩 공집합을 제외한 부분집합을 출력합니다.


    [ 풀이 시간 ]
    1. 09:20 ~ 09:35



 */
public class Find_Subset_DFS {

    static int n;
    static int[] ch;

    public static void DFS(int L) {
        if ( L == n+1 ) {
            StringBuilder str = new StringBuilder();
            for (int i=1; i<=n; i++ ) {
                if ( ch[i] == 1 ) str.append(i).append(" ");
            }
            System.out.println(str);
            return;
        }
        else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        ch = new int[n+1];
        DFS(1);
    }

}
