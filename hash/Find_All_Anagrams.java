package hash;
import java.util.*;
/*
    4. 모든 아나그램 찾기

    날짜 : 2023-11-07 / 2023-11-09

    [설명]
    S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
    아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


    [입력]
    첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
    S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


    [출력]
    S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


    [ 풀이 시간 ]
    1. 10:00 ~ 11:00 ( 풀이 실패 다시 풀어 볼 것 )
    2. 09:11 ~ 09:20 ( 풀이 성공, 근데 꼼꼼하게 풀 것 )


    [ 공부해야 할 내용 ]
    1. Map에서 equals도 동등의 역할을 할 수 있도록 오버라이드 되어있음. 그래서 equals로 맵의 값 비교가 가능하다.
       key값과 value값이 모두 동일하다면 equals 사용시 String 처럼 true가 나온다.
    2. 슬라이드 윈도우 방식으로 풀 것.


 */
public class Find_All_Anagrams {

    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for ( char c : str2.toCharArray() ) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for ( int i = 0; i < str2.length() -1; i ++ ) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        int lt = 0;
        for ( int rt = str2.length() -1; rt < str1.length(); rt ++ ) {
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);
            if ( map1.equals(map2) ) answer ++;
            map1.put(str1.charAt(lt), map1.get(str1.charAt(lt)) -1);
            if ( map1.get(str1.charAt(lt)) == 0) map1.remove(str1.charAt(lt));
            lt ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        System.out.println(solution(str1,str2));
    }
}
