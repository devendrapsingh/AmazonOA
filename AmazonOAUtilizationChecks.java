package InterviewProblems.AmazonInterviewProblems.AmazonOA;


//https://aonecode.com/amazon-online-assessment-utilization-checks


public class AmazonOAUtilizationChecks {


    public static void main(String[] args) {

        int [] nums={30,95,4,8,19,89};
        int instances = 100000000;
        System.out.println(solve(nums,instances));


    }
    static int solve(int [] averageUtil, int instances){

        for(int i=0;i<averageUtil.length;i++){

            int a = averageUtil[i];

            boolean flag = false;
            if(a<25){

                if(instances>1){

                    instances = (int)Math.ceil((double)instances/2);
                    flag  = true;
                }

            }else if(a>60){

                if(2*instances<=2*100000000){
                    instances =2*instances;
                    flag = true;
                }

            }
            if(flag){
                i=i+10;
            }

        }
    return instances;

    }
}
