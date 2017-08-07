package datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by thiago on 17/07/17.
 */
public class LinkedListCycle {

    static class Node{

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    private static Set<Integer> hashes = new HashSet<>();

    private static Integer hash(Node node) {
        if (node == null) {
            return 0;
        } else {
            Integer hash = 5 * node.hashCode();
            hash = hash * 13 + node.data;
            return node.next != null ? hash * 13 + node.next.data : hash;
        }
    }


    static boolean hasCycle(Node head) {

        int loop = 0;

        if(head == null || head.next == null){
            return false;
        }else{

            Node fast = head;
            Node slow = head;

            while(true){

                System.out.println(loop++);

                slow = slow.next;

                if(fast.next != null){
                    fast = fast.next.next;
                }else{
                    return false;
                }

                if(slow == null || fast == null)
                    return false;

                if(slow == fast)
                    return true;

            }

        }

    }


    public static void main(String[] args){

        Node th6 = new Node(55,null);

        Node th5 = new Node(55,th6);

        Node th4 = new Node(55,th5);

        Node rd = new Node(55,th4);

        Node nd = new Node(55,rd);

        Node st = new Node(101, nd);

        Node head = new Node(22,st);

        th6.next = head;

        System.out.println(hasCycle(head));


    }





}
