package stack_queue;
import java.util.*;
/*
    6. 공주 구하기

    날짜 : 2023-11-21

    [설명]
    정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
    정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
    정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
    왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
    그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
    그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
    한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
    그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
    이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다

    예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
    이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
    N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.


    [입력]
    첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.


    [출력]
    첫 줄에 마지막 남은 왕자의 번호를 출력합니다.


    [ 풀이 시간 ]
    1. 09:10 ~ 09:43 ( Queue에 대해 공부하느냐 조금 늦게 풀이 )


    [ 공부해야 할 내용 ]
    1. Queue를 구현할때 왜 LinkedList<>() 형식을 따르는가? : Queue를 구현할 때는 LinkedList를 구현체로 사용해야 한다.
    2. Queue의 주요 메서드를 공부할 것.
      = add(n) : n을 추가한다. 성공 시 true를 반환하고 큐가 꽉 차면 예외를 반환한다.
      = offer(n) : n을 추가한다.성공 시 true를 반환하고 큐가 꽉 차면 false를 반환한다.
      = remove() : 맨 앞의 value를 삭제하고 반환한다. 반환할 게 없으면 예외를 반환한다.
      = remove(n) : 해당 큐에 n가 있을 시 삭제하고 true를 반환한다. 없으면 false를 반환한다.
      = poll(); : 맨 앞의 value를 삭제하고 반환한다. 없으면 null을 반환한다.
      = element() : 삭제하지 않고 맨 앞의 value를 반환한다. 없으면 예외가 발생한다.
      = peek() : 삭제하지 않고 맨 앞의 value를 반환한다. 없으면 null을 반환한다.
      = clear(); 큐 초기화
      = size(); 큐 크기 반환
      = contains(n) : 큐에 n이 있는지 없는지 확인해서 삭제는 하지 않고 true, false로 반환한다.
      = isEmpty() : true false를 통해 해당 큐가 비어있는지 아닌지를 알려준다.


 */
public class Save_The_Princess {
    public static int solution(int n, int k) {
        int answer= 0;
        Queue<Integer> queue = new LinkedList<>();

        for ( int i=1; i<=n; i++ ) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            for ( int i=1; i<k; i++ ) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(solution(n, k));
    }
}
