package string;
import java.util.*;
/*
    6. 중복문자제거

    날짜 : 2023-10-18

    [설명]
    소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
    중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


    [입력]
    첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


    [출력]
    첫 줄에 중복문자가 제거된 문자열을 출력합니다.


    [ 풀이 시간 ]
    11:37 ~ 11:45


    [ 공부 해야 할 내용 ]
    1. List에서 contains(?); 를 사용하면, 해당 List 안에 해당 내용이 있는지 없는지 확인할 수 있다. return은 true, false로 된다.
    2. StringBuilder는 가변 가능한 문자열이므로, StringBuilder로 선언한 후 append를 활용하면 문자를 계속 추가 대입할 수 있다.
    3. 모든 클래스는 최상위 클래스인 Object로부터 파생된다.
       String은 Object 에서 equals()를 오버라이딩하여 주소 비교가 아니라, 문자열 내용 비교를 할 수 있게 되어있다.
       그러나 StringBuilder는 오버라이딩 하지 않아서 equals()를 할 경우 주소비교를 해버린다.
       즉,
       StringBuilder a = new StringBuilder("abc");
       StringBuilder b = new StringBuilder("abc");
       a.equals(b); 를 해도 false; 가 나온다는 것이다.
       이럴경우
       a.toString().equals(b.toString()); 이렇게 String 타입으로 변환을 한 후, equals 로 비교해주어야 한다.
    4. for문으로 String을 돌려서 , str.indexOf(str.charAt(i)) 와 i 가 같을 경우만 answer에 누적시키는 방법을 사용해도 됨.
       --> indexOf는 해당 데이터가 처음 시작되는 index를 반환함.

 */

public class Remove_Duplicate_Characters {

    public static String removeCharacters(String str) {

        StringBuilder answer = new StringBuilder();
        List<Character> cList = new ArrayList<>();

        for ( char c : str.toCharArray() ) {
            if ( !cList.contains(c) ) {
                cList.add(c);
                answer.append(c);
            }
        }

        return answer.toString();
    }

    public static String removeCharactersIndexOf(String str) {

        StringBuilder answer = new StringBuilder();

        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.indexOf(str.charAt(i)) == i ) {
                answer.append(str.charAt(i));
            }
        }

        return answer.toString();

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(removeCharacters(str));
        System.out.println(removeCharactersIndexOf(str));
    }

}
