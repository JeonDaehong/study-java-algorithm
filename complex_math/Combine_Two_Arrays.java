package complex_math;
import java.util.*;
/*
    1. 두 배열 합치기

    날짜 : 2023-10-30

    [설명]
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
    세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
    네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
    각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


    [출력]
    오름차순으로 정렬된 배열을 출력합니다.


    [ 풀이 시간 ]
    1. 09:10 ~ 09:15


    [ 공부해야 할 내용 ]
    < List 정렬 >
    1. Collections.sort(list); --> 오름차순
    2. Collections.sort(list, Collections.reverseOrder()); --> 내림차순

    < 배열 정렬 >
    3. Arrays.sort(arr); --> 오름차순
    4. Arrays.sort(arr, Collections.reverseOrder()); --> 내림차순
    5. Arrays.sort(arr, startIdx, endIdx); --> 원하는 인덱스 오름차순
    6. Arrays.sort(arr, startIdx, endIdx, Collections.reverseOrder()); --> 원하는 인덱스 내림차순

    7. 하지만 배열 2개를 합치는 문제를 물어본다면, Two Pointers Algorithm 을 물어보는 것이다.
       ( for문을 2번 돌지 않게끔 )
       ( 그리고 sort 자체가 for문을 돌리는것이므로 시간복잡도가 좋지 않음. 그래서 sort를 안쓰고 애초에 정렬해가며,
         list에 add 되게끔 알고리즘을 만드는 것이 좋다. )
      --> 아무튼 Two Pointer Algorithm 공부하기

 */

public class Combine_Two_Arrays {

    // 내가 풀어본 방법
    public static List<Integer> combine(int aCount, int bCount, int[] aArr, int[] bArr) {
        List<Integer> answer = new ArrayList<>();
        for ( int i=0; i<aCount; i++ ) {
            answer.add(aArr[i]);
        }
        for ( int i=0; i<bCount; i++ ) {
            answer.add(bArr[i]);
        }
        Collections.sort(answer);
        return answer;
    }

    // Two Pointer Algorithm 으로 할 것 !
    public static List<Integer> twoPointersAlgorithm(int aCount, int bCount, int[] aArr, int[] bArr) {
        List<Integer> answer = new ArrayList<>();

        int p1, p2;
        p1 = p2 = 0;

        while ( p1 < aCount && p2 < bCount ) {
            if ( aArr[p1] < bArr[p2] ) answer.add(aArr[p1++]);
            else answer.add(bArr[p2++]);
        }
        while ( p1 < aCount ) answer.add(aArr[p1++]);
        while ( p2 < bCount ) answer.add(bArr[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int aCount = scan.nextInt();
        int[] aArr = new int[aCount];
        for ( int i=0; i<aCount; i++ ) {
            aArr[i] = scan.nextInt();
        }
        int bCount = scan.nextInt();
        int[] bArr = new int[bCount];
        for ( int i=0; i<bCount; i++ ) {
            bArr[i] = scan.nextInt();
        }
        for ( int i : combine(aCount, bCount, aArr, bArr) ) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for ( int i : twoPointersAlgorithm(aCount, bCount, aArr, bArr) ) {
            System.out.print(i + " ");
        }
    }
}
