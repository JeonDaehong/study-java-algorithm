package array;
import java.util.*;
/*
    2. 보이는 학생

    날짜 : 2023-10-24

    [설명]
    선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
    선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
    (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


    [입력]
    첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


    [출력]
    선생님이 볼 수 있는 최대학생수를 출력한다.


    [ 풀이 시간 ]
    1. 09:35 ~ 09:38


    [ 공부 해야 할 내용 ]
    1. Collections 는 List 안에서 큰 수, 정렬, 역순, 랜덤 섞기 등을 지원해주는 클래스이다.
       ( List<Integer> 를 사용할 때 활용하기 좋은 클래스이다. )
       -->  Collections.sort(iList);  :  리스트 정렬
       -->  Collections.sort(iList , reverseOrder());  :  리스트 역순으로 정렬
       --> Collections.max(iList); Collections.min(iList);  :  최대, 최소값
       -->  Collections.shuffle(iList);  :  리스트 랜덤 섞기
       -->  Collections.binarySearch(iList, Key);  :  오름차순으로 정렬된 리스트에서 이진검색을 통해 위치를 반환, 실패시 -1반환
       -->  Collections.disjoint(iList, iList2);  :  두 리스트의 값이 완전히 다른지 검사 , 하나라도 같은값이 있으면 False


 */
public class Visible_Student {
    public static int visibleStudent(int[] iArr) {

        int answer = 0;
        List<Integer> iList = new ArrayList<>();

        for ( int i : iArr ) {
            if ( iList.size() == 0 || i > Collections.max(iList) ) {
                iList.add(i);
            }
        }

        answer = iList.size();

        return answer;
    }

    // max 변수를 활용한 방법
    public static int originalSolution(int[] iArr) {

        int answer = 0;
        int max = 0;
        List<Integer> iList = new ArrayList<>();

        for ( int i : iArr ) {
            if ( iList.size() == 0 || i > max ) {
                max = i;
                iList.add(i);
            }
        }

        answer = iList.size();

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] iArr = new int[count];
        for ( int i=0; i<count; i++ ) {
            iArr[i] = scan.nextInt();
        }
        System.out.println(visibleStudent(iArr));
        System.out.println(originalSolution(iArr));
    }
}
