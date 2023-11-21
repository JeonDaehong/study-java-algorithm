package stack_queue;
import java.util.*;
import java.io.*;
/*
    5. 쇠막대기

    날짜 : 2023-11-19

    [설명]
    여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
    레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
        • 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되,
    끝점은 겹치지 않도록 놓는다.
        • 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
        • 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
    아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치,
    수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.
    이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
        1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 드시 레이저를 표현한다.
        2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
    위 예의 괄호 표현은 그림 위에 주어져 있다.
    쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고,
    이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다.
    쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.


    [입력]
    한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.


    [출력]
    잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.


    [ 풀이 시간 ]
    1. 10:05 ~ 10:35


    [ 공부해야 할 내용 ]
    1. 파이프를 자를 때, ( ) 가 나오면 레이저인데, 스택 사이즈 만큼 더하고
       ) ) 가 나오면 그냥 막대 추가인데 +1을 해야 하는 이유를 공부. ( 진짜 모르겠으면 그냥 외우기 )

    2. Scanner 와 BufferedReader  ,  System out print 와 BufferedWriter 의 차이 공부하기
       위의 함수들은 비슷한 기능을 하지만 속도와 효율성 면에서 차이를 보인다.
       전자의 함수들은 한 문자 한 문자 키보드의 입력에 따라 프로그램에 전달하지만
       후자의 함수들은 메모리 버퍼에 문자들을 보관하고 있다가 버퍼가 가득 차거나 버퍼 플러시(flush)가 되는 순간 프로그램에 전달한다.

       즉, 이벤트 발생 시 건별로 데이터를 이동시키는 것보다 버퍼를 이용해 데이터의 이동을 최소화한 방식이 속도와 효율 면에서 유리하다.
       다만 Buffered 는 String 타입으로만 가능하다.


 */
public class Iron_Bar {
    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for ( int i = 0; i < str.length(); i ++ ) {
            if ( str.charAt(i) == '(' ) {
                stack.push('(');
            } else  {
                stack.pop();
                if ( str.charAt(i - 1) == '(' ) {  //  레이저
                    answer += stack.size();
                } else { // 파이프
                    answer ++;
                }
            }
        }
        return answer;

    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write(String.valueOf(solution(str))); // bw는 무조건 String 타입
        bw.flush();
        br.close();
        bw.close();
    }
}
