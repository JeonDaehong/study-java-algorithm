package hash;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
    1. 학급 회장

    날짜 : 2023-11-04

    [설명]
    학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
    투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
    선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
    반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.


    [입력]
    첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
    두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.


    [출력]
    학급 회장으로 선택된 기호를 출력합니다.


    [ 풀이 시간 ]
    1. 09:15 ~ 09:34 ( 풀이 실패 : Runtime Error )
    2. 09:40 ~ 09:45 ( char 배열로 받던 scan을, String으로 받은 후 toCharArray() 로 계산하여 속도 문제 해결 )


    [ 공부해야 할 내용 ]
    1. 연속된 문자열에서 문자를 뽑아내는 문제는 가급적 for ( char c : s.toCharArray() ) 를 활용하자. 시간이 단축된다.
    2. HashMap 을 활용할 때, 함께 사용 가능한 메서드들을 알아야한다.
      - .put(key, value) : 키와 값을 추가한다. 같은 key가 있으면 덮어 씌워버린다.
      - .remove(key) : 해당 key, value를 완전히 삭제한다.
      - .get(key) : 해당 key의 값을 불러온다.
      - .size() : map의 길이를 구한다.
      - .containsKey(key) / .containsValue(val) : 해당 key나 Value에 해당 값이 있는지를 확인한다.
      - .keySet, Values : for문에 넣음으로써 key나 value를 통한 for문을 돌릴 수 있다.
                          그냥 프린트하면 연속되어 출력된다. ex) [ a, b, c, d, e ]
      - .getOrDefault(key, defaultValue) : key를 넣어보고, 해당 key가 없다면 defaultValue를 반환한다. key가 있으면 그 key의 value를 반환한다.
      - .clear() : 모두 지운다.
      - .isEmpty() : element가 있는지 없는지 boolean으로 반환해준다.
      - .forEach : 모든 키, 밸류를 순회한다.
                   ex) map.forEach((key, val) -> {
                         System.out.println(key);
                         System.out.println(val);
                       });

        https://gre-eny.tistory.com/97 해당 링크를 확인하여, hashmap의 여러 메서드를 더 확인할 수 있다.

 */
public class Class_President {

    public static char solution(String s) {

        char answer = 0;
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> hashMap = new HashMap<>();
        for ( char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for ( char key : hashMap.keySet() ) {
            if ( max < hashMap.get(key) ) {
                max = hashMap.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(solution(s));
    }

}
