package Array;
import java.util.*;
/*
    3. 가위 바위 보

    날짜 : 2023-10-24

    [설명]
    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
    예를 들어 N=5이면
    -----------------
      회수  1 2 3 4 5
      A    2 3 3 1 3
      B    1 1 2 2 3
      승자  A B A B D
    -----------------
    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


    [입력]
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


    [출력]
    각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


    [ 풀이 시간 ]
    1. 09:55 ~ 10:05


 */
public class Rock_Paper_Scissors {

    public static String game(int a, int b) {
        if (a == 1 && b == 3 || a == 2 && b == 1 || a == 3 && b == 2) {
            return "A";
        } else if (b == 1 && a == 3 || b == 2 && a == 1 || b == 3 && a == 2) {
            return "B";
        }
        return "D";
    }
    public static String[] result(int count, int[] aArr, int[] bArr) {

        String[] answer = new String[count];

        for ( int i=0; i<count; i++ ) {
            answer[i] = game(aArr[i], bArr[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] aArr = new int[count];
        int[] bArr = new int[count];
        for ( int i=0; i<count; i++ ) {
            aArr[i] = scan.nextInt();
        }
        for ( int i=0; i<count; i++ ) {
            bArr[i] = scan.nextInt();
        }

        String[] result = result(count, aArr, bArr);

        for ( String str : result ) {
            System.out.println(str);
        }

    }
}
