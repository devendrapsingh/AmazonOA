package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {


    public static void main(String[] args) {

        int [][] points ={{3,3},{5,-1},{-2,4}};
        int k  = 2;

        int [][] res = KClosestPoints(points,k);

        for(int [] p: res){
            System.out.println(Arrays.toString(p));
        }
    }

    static int [][] KClosestPoints(int [][] points, int k){

       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->((b[1]*b[1]+b[0]*b[0])-(a[1]*a[1]+a[0]*a[0])));

       for(int [] p : points){

           pq.add(p);

           if(pq.size()>k){
               pq.poll();
           }

       }
       int [][] res = new int[k][2];

       while(!pq.isEmpty()){

           res[--k] = pq.poll();
       }
       return res;
    }
}
