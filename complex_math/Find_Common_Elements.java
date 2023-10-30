package complex_math;
import java.util.*;
/*
    2. 공통원소 구하기

    날짜 : 2023-10-30

    [설명]
    A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    각 집합의 원소는 1,000,000,000이하의 자연수입니다.


    [출력]
    두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


    [ 풀이 시간 ]
    1. 10:00 ~ 10:07 ( 풀이 실패 : Time Limit Exceeded )
    1. 11:35 ~ 11:43 ( 풀이 성공 : Two Pointers Algorithm 공부 )


    [ 공부해야 할 내용 ]
    1. Two Pointers Algorithm 공부

 */
public class Find_Common_Elements {
    
    // 시간 초과된 풀이
    public static List<Integer> findElements(int aCount, int bCount, int[] aArr, int[] bArr) {
        List<Integer> answer = new ArrayList<>();
        for ( int i=0; i<aCount; i++) {
            for ( int j=0; j<bCount; j++ ) {
                if ( aArr[i] == bArr[j] ) {
                    answer.add(aArr[i]);
                    break;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    // 다시 풀어본 풀이
    public static List<Integer> findElements2(int aCount, int bCount, int[] aArr, int[] bArr) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        int p1, p2;
        p1 = p2 = 0;
        while ( p1 < aCount && p2 < bCount ) {
            if ( aArr[p1] < bArr[p2] ) {
                p1++;
            } else if ( bArr[p2] < aArr[p1] ) {
                p2++;
            } else {
                answer.add(aArr[p1++]);
                p2++;
            }
        }
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
        for ( int i : findElements(aCount, bCount, aArr, bArr) ) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for ( int i : findElements2(aCount, bCount, aArr, bArr) ) {
            System.out.print(i + " ");
        }
    }
}
