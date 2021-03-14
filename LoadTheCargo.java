package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.PriorityQueue;

public class LoadTheCargo {

    public static void main(String[] args) {

        int [] con = {3,1,2};
        int [] item = {1,2,3};
        int size = 4;
        System.out.println(solve(con,item,size));

    }
    public static int solve(int [] container, int [] item, int size){

        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));


        for(int i=0;i<container.length;i++){

            for(int j=0;j<container[i];j++){

                pq.add(item[i]);
            }
        }

        while (!pq.isEmpty() && size-->0){

                ans+=pq.poll();
        }
        return ans;
    }
}
