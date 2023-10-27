package array;
import java.util.*;
/*
    5. 소수(에라토스테네스 체)

    날짜 : 2023-10-24

    [설명]
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


    [입력]
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


    [출력]
    첫 줄에 소수의 개수를 출력합니다.


    [ 풀이 시간 ]
    1. 10:32 ~ 10:35 ( 오답 : Time Limit Excee )


    [ 공부해야 할 내용 ]
    1.  메모리 사용량 체크 하는 Code를 외울 것.
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory / (1024 * 1024) + " MB");
    2. 시간 체크하는 Code를 외울 것.
        long startTime = System.currentTimeMillis();
        // 코드
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");
     3. 에라토스테네스의 체 알고리즘 자체는 외우기
     4. Arrays.fill(arr, a);   //   뱌열의 전체를 a로 채워달라

 */

public class Eratosthenes_Sieve {

    /*
    // 오답 코드 ( Time Limit Excee )
    public static int primeNumbers_timeLimitExceeCode(int num) {
        List<Integer> iList = new ArrayList<>();
        for (int i=2; i<=num; i++) {
            int count = 0;
            for (int j=2; j<=i; j++ ) {
                if ( i % j == 0) count ++;
                if (count >= 2) break;
            }
            if (count == 1) iList.add(i);
        }
        return iList.size();
    }
     */

    // 에라토스테네스의 체 활용
    public static int eratosthenesSieve(int num) {

        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for ( int i=2; i*i<=num; i++) {
            if(isPrime[i]) {
                for ( int j=i*i; j<=num; j+=i ) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for ( boolean tf : isPrime ) {
            if(tf) answer++;
        }

        return answer;
    }

    // 에라토스테네스의 체 2번째 방법
    public static int eratosthenesSieve2(int num) {

        int answer = 0;
        boolean[] isPrime = new boolean[num+1];
        Arrays.fill(isPrime, true);

        for ( int i=2; i<=num; i++) {
            if(isPrime[i]) {
                answer ++;
                for ( int j=i; j<=num; j+=i ) {
                    isPrime[j] = false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        //System.out.println(primeNumbers_timeLimitExceeCode(num));

        //long startTime = System.currentTimeMillis();

        System.out.println(eratosthenesSieve(num));
        System.out.println(eratosthenesSieve2(num));

        //long endTime = System.currentTimeMillis();
        //System.out.println((endTime - startTime) + " ms");

    }
}
