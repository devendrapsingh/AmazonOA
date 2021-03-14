package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.HashSet;
import java.util.Set;

public class TwoSum_Unique {

    public static void main(String[] args) {

        int [] nums ={1,1};
        int target  =2;
        System.out.println(twoSum(nums,target));
    }
    static int twoSum(int [] nums, int target){

        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int ans=0;
        for(int i : nums){
            int sum = target-i;
            if(set.contains(sum) && !seen.contains(sum)){
                seen.add(sum);
                ans++;
            }
            set.add(i);

        }
        return ans;

    }
}
