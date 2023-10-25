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

    2. StringBuilder를 못쓰게 하는 경우가 있을 수 있으므로, 숫자 뒤집는 공식 외울 것.
        int res = 0;
        while (i != 0) {
            res = (res * 10) + (i % 10);
            i /= 10;
        }

    3. 소수 구하는 메서드를 외울 것.
        public static boolean isPrime(int num) {
            if ( num == 1 ) return false;
            for ( int i=2; i<num; i++ ) {
                if ( num % i == 0 ) return false;
            }
            return true;
        }


 */
public class Flipped_Decimal {

    // 소수인지 확인해주는 함수
    public static boolean isPrime(int num) {
        if ( num == 1 ) return false;
        for ( int i=2; i<num; i++ ) {
            if ( num % i == 0 ) return false;
        }
        return true;
    }

    // Solution 1
    public static List<Integer> flippedDecimal(int[] iArr) {
        List<Integer> iList = new ArrayList<>();
        for (int i : iArr) {
            String tmp = String.valueOf(i);
            tmp = new StringBuilder(tmp).reverse().toString();
            i = Integer.parseInt(tmp);

            if (isPrime(i)) iList.add(i);
        }
        return iList;
    }

    // Solution 2
    public static List<Integer> anotherSolution(int[] iArr) {
        List<Integer> iList = new ArrayList<>();
        for (int i : iArr) {
            int res = 0;
            while (i != 0) {
                res = (res * 10) + (i % 10);
                i /= 10;
            }

            if (isPrime(res)) iList.add(res);
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

        for (int i : flippedDecimal(iArr)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : anotherSolution(iArr)) {
            System.out.print(i + " ");
        }
    }
}
