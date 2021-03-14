package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {


    public static void main(String[] args) {

        String data = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] banned = new String[]{"hit"};

        System.out.println(mostCommonWord(data,banned));
    }


    public static String mostCommonWord(String paragraph, String[] banned) {


        Set<String> set = new HashSet<>();

        for(String s: banned){
            set.add(s);
        }


        String [] str = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for(String s :str){

            if(!set.contains(s)){
                map.put(s,map.getOrDefault(s,0)+1);

            }
        }
        String res = null;
        int ans =0;
        for(String key:map.keySet()){

            if(map.get(key)>ans){
                ans = map.get(key);
                res = key;
            }

        }
        return res;

    }
}
