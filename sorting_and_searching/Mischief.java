package sorting_and_searching;
import java.util.*;
/*
    6. 장난꾸러기

    날짜 : 2023-12-11

    [설명]
    새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
    철수네 반에는 N명의 학생들이 있습니다.
    선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
    제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
    그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
    선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
    철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
    차례로 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.
    두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다.
    키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.


    [출력]
    첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.


    [ 풀이 시간 ]
    1. 09:10 ~ 09:30


    [ 공부해야 할 내용 ]
    1. 배열 정렬 문제에서 중간에만 정렬상태가 다른 값이 끼어있을 경우, 똑같은 배열을 clone(); 으로 만들고
       이후 clone 배열만 정렬을 한 후, 다른 부분을 비교해주면 된다.

 */

public class Mischief {

    public static String solution(int n, int[] arr) {
        String answer = "";

        int[] tmpArr = arr.clone();
        Arrays.sort(tmpArr);

        for ( int i=0; i<arr.length; i++ ) {
            if ( arr[i] != tmpArr[i] ) answer += ((i+1) + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for ( int i=0; i<n; i++ ) {
            arr[i] = scan.nextInt();
        }
        System.out.print(solution(n, arr));
    }

}
