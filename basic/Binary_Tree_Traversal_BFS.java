package basic;
import java.util.*;
/*
    7.  이진트리순회 ( BFS : 넓이 우선 탐색 / 레벨 탐색 )

    날짜 : 2023-12-21

    [설명]
    이진트리 BFS 에 관한 내용을 공부하고 정리하였습니다.
    이 부분은 문제풀이가 아닙니다.


    [ 공부해야 할 내용 ]
    1. 이진트리 BFS 에 대한 이론 공부
    2. 루트에서 n 번만에 가는 곳들 다 탐색, 최단 거리 탐색 등에 사용된다.
    3. BFS 는 Queue 를 이용한다.


 */
public class Binary_Tree_Traversal_BFS {

    static Node root;

    public static void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while ( ! Q.isEmpty() ) {
            int len = Q.size();
            System.out.print("Level " + level + " : ");
            for ( int i=0; i<len; i++ ) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if ( cur.lt != null ) Q.offer(cur.lt);
                if ( cur.rt != null ) Q.offer(cur.rt);
            }
            level ++;
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);

    }

}
