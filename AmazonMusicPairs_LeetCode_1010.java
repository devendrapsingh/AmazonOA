package InterviewProblems.AmazonInterviewProblems.AmazonOA;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

import java.util.HashMap;
import java.util.Map;

/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.


 */
public class AmazonMusicPairs_LeetCode_1010 {

    public static void main(String[] args) {


    }
    public static int numPairsDivisibleBy60(int[] time) {

        for(int i=0;i<time.length;i++){
            time[i] = time[i] % 60;
        }

        int ans  =0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<time.length;i++){

            int key  = (60-time[i])%60;  // to handle when time[i]  become 0 due to above code

            if(map.containsKey(key)){
                ans+=map.get(key);
            }
            map.put(time[i],map.getOrDefault(time[i],0)+1);


        }
        return ans;
    }

}
