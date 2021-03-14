package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.*;

public class Substrings_of_size_K_with_K_distinctChars {

    public static void main(String[] args) {

        String s = "awaglk";
        int k = 4;

        System.out.println(solve(s, k).toString());


    }

    static List<String> solve(String s, int k) {

        int low = 0;
        int high = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<String> ans = new HashSet<>();
        while (high < s.length()) {
            char sh = s.charAt(high);
            map.put(sh, map.getOrDefault(sh, 0) + 1);

            if (high - low + 1 == k) {

                if (map.size() == k-1){ // find k-1 distinct chars in k window size {
                    ans.add(s.substring(low, high+1));
                }
                map.put(s.charAt(low), map.getOrDefault(s.charAt(low), 0) - 1);

                if (map.get(s.charAt(low)) <= 0) {
                    map.remove(s.charAt(low));
                }
                low++;
            }
            high++;
        }
        return new ArrayList<>(ans);
    }

}
