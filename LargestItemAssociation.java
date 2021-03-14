package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.*;
//https://leetcode.com/discuss/interview-question/783947/amazon-oa-sde-1-aug-2020

/*
Q1. Given a list of item association relationships, write an algorithm that outputs the
largest item association group. If two groups have the same number of items then select
 the group which contains the item that appears first in lexicographic order.

Input :
[[Item1, Item2], [Item3, Item4], [Item4, Item5]]

Output :
[Item3, Item4, Item5]

 */
public class LargestItemAssociation {

    static class PairString {

        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        List<PairString> data = new ArrayList<>();
        data.add(new PairString("I1", "I2"));
        data.add(new PairString("I3", "I4"));
        data.add(new PairString("I4", "I5"));
        data.add(new PairString("I2", "I5"));

        solveHelper(data);


    }

    static void solveHelper(List<PairString> data) {

        Map<String, List<String>> map = new HashMap<>();

        for (PairString pair : data) {

            if (!map.containsKey(pair.first)) {
                map.put(pair.first, new ArrayList<>());
            }
            map.get(pair.first).add(pair.second);
        }

        Set<String> set = new HashSet<>();
        int prevSize = 0;
        List<String> res = new ArrayList<>();

        for (String s : map.keySet()) {

            List<String> mid = new ArrayList<>();
            if (!set.contains(s)) {
                mid.add(s);
                dfs(set, map, s, mid);
            }
            if (mid.size() > prevSize) {
                prevSize = mid.size();
                res = new ArrayList<>(mid);
            } else if (mid.size() == res.size()) {
                Collections.sort(res);
                Collections.sort(mid);

                if (res.get(0).compareTo(mid.get(0)) > 0) {
                    prevSize = mid.size();
                    res = new ArrayList<>(mid);
                }
            }
        }
        System.out.println(res.toString());
    }

    static void dfs(Set<String> set, Map<String, List<String>> map, String s, List<String> mid) {

        set.add(s);

        for (String str : map.getOrDefault(s, new ArrayList<>())) {

            if (!set.contains(str)) {
                mid.add(str);
                dfs(set, map, str, mid);
            }
        }

    }

}
