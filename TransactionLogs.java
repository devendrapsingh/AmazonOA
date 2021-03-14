package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.*;

public class TransactionLogs {


    public static void main(String[] args) {

        List<String> input = new ArrayList<>(Arrays.asList("345366 89921 45", "029323 38239 23",
                "38239 345366 15", "029323 38239 77",
                "345366 38239 23", "029323 345366 13",
                "38239 38239 23"));
        int  threshold = 3;
        System.out.println(solve(input,threshold).toString());

    }
    static List<String> solve(List<String> input, int threshold){

        Map<String,Integer> map = new HashMap<>();

        for(String str : input){

            String [] s = str.split("\\s+");

            if(s[0].equals(s[1])){
                map.put(s[0],map.getOrDefault(s[0],0)+1);
            }else {
                map.put(s[0], map.getOrDefault(s[0], 0) + 1);
                map.put(s[1], map.getOrDefault(s[1], 0) + 1);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key)>=threshold){
                ans.add(0,key);
            }
        }
        ans.sort(Collections.reverseOrder());
        return ans;
    }

}
