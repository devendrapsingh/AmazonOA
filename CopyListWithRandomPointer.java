package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


    public static void main(String[] args) {

        Node p = new Node(12);
        p.next = new Node(13);
        p.next.next = new Node(15);
        p.next.next.next = new Node(45);


        Node res = copyRandomList(p);
        res.print();

    }
    public  static Node copyRandomList(Node head) {

        Node curr =head;
        Node temp = head;
        Map<Node, Node> map  =new HashMap<>();

        while(curr!=null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        while(head!=null){

            map.get(head).next = map.get(head.next);
            map.get(head).random  =map.get(head.random);
            head = head.next;
        }
        return map.get(temp);
    }
    static class Node {

        Node next;
        Node random;
        int val;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        void print(){
            Node root = this;

            while(root!=null){

                System.out.print(root.val+" ");
                root = root.next;
            }
            System.out.println();
        }
    }

}
