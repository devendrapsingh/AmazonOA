package InterviewProblems.AmazonInterviewProblems.AmazonOA;

public class StorageOptimization {

    public static void main(String[] args) {

        int [] h ={4};
        int [] v ={2};

        System.out.println(maxArea(6,6,h,v));
    }

    static  int maxArea(int n, int m, int[] horizontalCuts, int[] verticalCuts) {

        boolean [] h = new boolean[n+1];
        boolean [] v = new boolean[m+1];

        for(int i=0;i<horizontalCuts.length;i++){
            h[horizontalCuts[i]]=true;
        }

        for(int i=0;i<verticalCuts.length;i++){
            v[verticalCuts[i]]=true;
        }

        int maxRow = 0, maxCol =0;
        int j=0;
        for(int i=1;i<=n;i++){

            if(!h[i]){
                j=0;
            }else{
                j++;
                maxRow = Math.max(maxRow,j);
            }
        }
        j=0;
        for(int i=1;i<=m;i++){

            if(!v[i]){
                j=0;
            }else{
                j++;
                maxCol = Math.max(maxCol,j);
            }
        }
        return (1+maxRow)*(1+maxCol);


    }



}
