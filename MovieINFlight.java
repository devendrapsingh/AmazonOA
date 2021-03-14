package InterviewProblems.AmazonInterviewProblems.AmazonOA;

//https://www.geeksforgeeks.org/amazon-interview-experience-sde-2-10/
//https://leetcode.com/discuss/interview-question/313719/Amazon-Online-Assessment-2019-Tho-sum-closest/291502

/*
    You are on a flight and wanna watch two movies during this flight.
You are given List<Integer> movieDurations which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).

Find the pair of movies with the longest total duration and return they indexes. If multiple found, return the pair with the longest movie.

Example 1:

Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
Output: [0, 6]
Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
 */


import java.util.Arrays;

public class MovieINFlight {

    public static void main(String[] args) {

        int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
        int d1 = 250;
        System.out.println(Arrays.toString(solve(movie_duration1,d1-30)));
        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
        int d2 = 250;
        System.out.println(Arrays.toString(solve(movie_duration2,d2-30)));
        int[] movie_duration3 = {90, 85, 75, 60, 120,110,110, 150, 125};
        int d3 = 250;
        System.out.println(Arrays.toString(solve(movie_duration3,d3-30)));
    }
    //using sorting
    static int[] solve(int [] nums, int d){

        int [][] input = new int[nums.length][2];

        for(int i=0;i<nums.length;i++){
            input[i][0] = nums[i];
            input[i][1] = i;
        }
        Arrays.sort(input,(a,b)->(a[0]-b[0]));

        int low =0;
        int high = nums.length-1;

        int  i=0,j=0;
        int sum =0;
        while(low<high){

            int a = input[low][0], b = input[high][0];
            if(a+b<=(d)){
                if(sum<a+b){
                    sum = a+b;
                    i  = input[low][1];
                    j = input[high][1];
                }
                low++;
            }else if(a+b>(d)){
                high --;
            }
        }
       return new int[]{i,j};
    }
}
