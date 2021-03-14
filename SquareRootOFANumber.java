package InterviewProblems.AmazonInterviewProblems.AmazonOA;

public class SquareRootOFANumber {


    public static void main(String[] args) {

        int n=49;
        System.out.println(solve(n));

    }
    static double solve(int n){

        double low = 0,high = n;
        while(low<high){
            double mid = (low+high)/2;
            double mul = mid*mid;
            if(mul==n || Math.abs(mul-n)<.000001)
            {
               return mid;
            }
            else if(mul<n)
                low = mid;
            else
                high = mid-1;
        }
        return low;

    }
}
