package Array;
import java.util.*;
/*
    6. 뒤집은 소수

    날짜 : 2023-10-25

    [설명]
    N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
    예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
    첫 자리부터의 연속된 0은 무시한다.


    [입력]
    첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
    각 자연수의 크기는 100,000를 넘지 않는다.


    [출력]
    첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.


    [ 풀이 시간 ]
    1. 08:50 ~ 08:57


    [ 공부해야 할 내용 ]
    1. 숫자를 뒤집을 때, String 으로 바꾼 후 StringBuilder 를 이용하면 편하게 뒤집을 수 있다.


 */
public class Flipped_Decimal {
    public static List<Integer> flippedDecimal(int[] iArr) {
        List<Integer> iList = new ArrayList<>();
        for (int i : iArr) {
            String tmp = String.valueOf(i);
            tmp = new StringBuilder(tmp).reverse().toString();
            i = Integer.parseInt(tmp);
            int checkCount = 0;
            for ( int j=2; j<=i; j++) {
                if (i%j == 0) checkCount ++;
                if (checkCount > 1) break;
            }
            if (checkCount == 1) iList.add(i);
        }
        return iList;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        int[] iArr = new int[cnt];
        for ( int i=0; i<cnt; i++ ) {
            iArr[i] = scan.nextInt();
        }
        List<Integer> iList = flippedDecimal(iArr);
        for (int i : iList) {
            System.out.print(i + " ");
        }
    }
}
