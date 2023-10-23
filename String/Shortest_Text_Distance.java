package String;
import java.util.*;
/*
    10. 가장 짧은 문자거리

    날짜 : 2023-10-23

    [설명]
    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
    문자열의 길이는 100을 넘지 않는다.


    [출력]
    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


    [ 풀이 시간 ]
    1. 11:15 ~ 11:40


    [ 공부 해야 할 내용 ]
    1. Math.abs(i); 를 해주면, 절댓값이 입력된다.  //  Math.min(a, b); 를 하면 a, b중 작은 값이 들어간다.
    2. 단어간의 거리 계산을 할 때는 해당 단어가 들어간 인덱스를 List 로 먼저 정리해둔 뒤, 비교해주면 쉽다.
    3. 왼쪽에서 부터 거리 계산, 오른쪽으로부터 거리 계산을 하여 더 작은 수를 비교하는 방법도 있다.

 */
public class Shortest_Text_Distance {

    // 이미 List에 index를 넣고 비교하는 방법
    public static int[] findDistance(String str, char c) {

        List<Integer> iList = new ArrayList<>();
        int[] iArr = new int[str.length()];

        for ( int i = 0; i < str.length(); i++ ) {
            if (str.charAt(i) == c) iList.add(i);
        }

        for ( int i = 0; i < str.length(); i++ ) {

            int min = 9999;

            for ( int j : iList ) {
                if ( (j - i) < min ) min = Math.abs(j - i);
            }

            iArr[i] = min;
        }

        return iArr;
    }

    // 왼쪽부터 쭉 비교, 오른쪽부터 쭉 비교하는 방법
    public static int[] findDistanceAnotherSolution(String str, char c) {

        int[] iArr = new int[str.length()];

        int p = 9999;

        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) == c ) {
                p = 0;
            } else {
                p ++;
            }
            iArr[i] = p;
        }

        p = 9999;

        for ( int i = str.length() -1; i >= 0; i-- ) {
            if ( str.charAt(i) == c ) {
                p = 0;
            } else {
                p ++;
            }
            iArr[i] = Math.min(iArr[i], p);
        }

        return iArr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char c = scan.next().charAt(0);
        for ( int i : findDistance(str, c) ) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for ( int i : findDistanceAnotherSolution(str, c) ) {
            System.out.print(i + " ");
        }
    }
}
