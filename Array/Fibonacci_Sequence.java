package Array;
import java.util.*;

/*
    4. 피보나치 수열

    날짜 : 2023-10-24

    [설명]
    1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


    [입력]
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


    [출력]
    첫 줄에 피보나치 수열을 출력합니다.


    [ 풀이 시간 ]
    1. 10:10 ~ 10:25


 */
public class Fibonacci_Sequence {
    public static List<Integer> fibonacci(int number) {

        List<Integer> iList = new ArrayList<>();

        for ( int i=0; i<number; i++ ) {
            if (iList.size() < 2) {
                iList.add(1);
            } else {
                iList.add(iList.get(i-2) + iList.get(i-1));
            }
        }
        return iList;
    }

    // 뱌열이나 List를 사용하지 않고 하는 손코딩 방법
    public static void originalFibonacci(int number) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i=2; i<number; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        List<Integer> iList = fibonacci(number);
        for ( int i : iList ) {
            System.out.print(i + " ");
        }

        System.out.print("\n");
        originalFibonacci(number);
    }
}
