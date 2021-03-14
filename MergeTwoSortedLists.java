package InterviewProblems.AmazonInterviewProblems.AmazonOA;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode p = new ListNode(12);
        p.next = new ListNode(13);
        p.next.next = new ListNode(16);


        ListNode q = new ListNode(1);
        q.next = new ListNode(3);
        q.next.next = new ListNode(6);

        ListNode res = merge(p,q);
        p.print(res);
    }

    static ListNode merge(ListNode p , ListNode q){

        if(p==null || q==null){
            return p==null ? q : p;
        }
        if(p.val<=q.val){
            p.next = merge(p.next,q);
            return p;
        }else{
            q.next = merge(p,q.next);
            return q;
        }
    }


    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            next = null;
        }

        public void print(ListNode root){

            while(root!=null){
                System.out.print(root.val+" ");
                root = root.next;
            }
            System.out.println();

        }
    }

}
