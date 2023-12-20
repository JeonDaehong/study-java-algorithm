package basic;
import java.util.*;
/*
    5.  이진트리순회 ( DFS : 깊이 우선 탐색 )

    날짜 : 2023-12-20

    [설명]
    이진트리 DFS 에 관한 내용을 공부하고 정리하였습니다.
    이 부분은 문제풀이가 아닙니다.


    [ 공부해야 할 내용 ]
    1. 이진트리 DFS 에 대한 이론 공부
    2. 전위, 중위, 후위 탐색의 개념을 알아야 함.


 */
class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
public class Binary_Tree_Traversal_DFS {

    static Node root;
    
    // 전위
    public static void DFS1(Node root) {
        if ( root == null ) return;
        else {
            System.out.print(root.data + " ");
            DFS1(root.lt);
            DFS1(root.rt);
        }
    }

    // 중위
    public static void DFS2(Node root) {
        if ( root == null ) return;
        else {
            DFS2(root.lt);
            System.out.print(root.data + " ");
            DFS2(root.rt);
        }
    }

    // 후위
    public static void DFS3(Node root) {
        if ( root == null ) return;
        else {
            DFS3(root.lt);
            DFS3(root.rt);
            System.out.print(root.data + " ");
        }
    }

    /**
     *                                                                       root ( 주소 = 100, Data = 1, lt = 200, rt = 300 )
     *                                                                       /                                       \
     *                             root.lt ( 주소 = 200, Data = 2, lt = 400, rt = 500 )                             root.rt ( 주소 = 300, Data = 3, lt = 600, rt = 700 )
     *                                     /                            \                                                                   /               \
     *      root.lt.lt ( 주소 = 400, Data = 4, lt = null, rt = null )   root.lt.rt ( 주소 = 500, Data = 5, lt = null, rt = null )      root.rt.lt ( 생략 )  root.rt.rt ( 생략 )
     *
     *      이런 구조이다.
     *
     */
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        System.out.println("전위");
        DFS1(root);

        System.out.println("\n");
        System.out.println("중위");
        DFS2(root);

        System.out.println("\n");
        System.out.println("후위");
        DFS3(root);

    }


}
