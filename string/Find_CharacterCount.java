package string;

import java.util.*;

/**
   1. 문자 찾기

   날짜 : 2023-10-13

   [ 설명 ]
   한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
   대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.


   [ 입력 ]
   첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
   문자열은 영어 알파벳으로만 구성되어 있습니다.


   [ 출력 ]
   첫 줄에 해당 문자의 개수를 출력한다.


    [ 풀이시간 ]
    1. 09:55 ~ 10:04 ( 직접풀이 : 오답 )
        -> 오답 이유 : 문자열(String)은 toLowerCase();를 해주었으나, 문자(Char)는 toLowerCase(t);를 해주지 않았음.
                      문자열과 문자 둘 다 통일해서 대소문자 변환을 해줘야 함.
        -> 오답 이유 : 채점 사이트에서 채점할 때는 백준 방식을 이용해야하므로, class 이름은 Main으로 바꿔서 채점 진행.


    2. 10:13 ~ 10:15 ( 해설 확인 후, 다시 풀이 : 정답 )


    [ 공부 해야 할 내용 ]
    1. 문자열 대소문자로 수정하는것. str = str.toUpperCase(); / str = str.toLowerCase();
    2. 문자 대소문자로 수정하는것. c = Character.toUpperCase(c); / c = Character.toLowerCase(c);
    3. 문자열을 루프문 돌리는 방법 for(char c : str.toCharArray())

 */

public class Find_CharacterCount {

    public static int find(String sentence, char character) {

        int answer = 0;

        sentence = sentence.toLowerCase();
        character = Character.toLowerCase(character);

        for (char c : sentence.toCharArray()) {
            if ( c == character ) answer ++;
        }

        return answer;
    }

    // Stream을 이용한 메서드
    public static int find_stream(String sentence, char character) {
        sentence = sentence.toLowerCase();
        char finalCharacter = Character.toLowerCase(character);
        return (int) sentence.chars()
                .filter(c -> c == finalCharacter)
                .count();
    }

    public static void main(String[] args) {

        int answer;

        Scanner scan = new Scanner(System.in);
        String sentence = scan.next();
        char character = scan.next().charAt(0); // 한 글자만 반영

        System.out.println(find(sentence, character));
        System.out.println(find_stream(sentence, character));

    }

}
