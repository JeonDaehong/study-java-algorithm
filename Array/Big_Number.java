package Array;
import java.util.*;
/*
    1. 큰 수 출력하기

    날짜 : 2023-10-24

    [설명]
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)


    [입력]
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


    [출력]
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.


    [ 풀이 시간 ]
    1. 09:25 ~ 09:29


 */
public class Big_Number {

    public static List<Integer> bigNumberExport(int[] iArr) {
        List<Integer> iList = new ArrayList<>();
        for ( int i=0; i<iArr.length; i++) {
            if ( i == 0 ) {
                iList.add(iArr[i]);
            } else {
                if (iArr[i-1] < iArr[i]) {
                    iList.add(iArr[i]);
                }
            }
        }
        return iList;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] iArr = new int[count];
        for (int i=0; i<count; i++) {
            iArr[i] = scan.nextInt();
        }

        for ( int i :  bigNumberExport(iArr) ) {
            System.out.print(i + " ");
        }

    }
}
