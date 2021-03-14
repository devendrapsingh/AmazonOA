package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/992179/Amazon-or-OA-2021-or-LRU-Cache-Misses
/*
A virtual memory management system use least-recently-Used (LRU) cache. When a requested memory page is not in the cache and the cache is full, the page that was least-recently-used should be removed from the cache to make room for the requested page. If the cache is not full, the requested page can simply be added to the cache and considered the most-recently-used page in the cache. A given page should occur at most once in the cache.

Given the maximum size of the cache and a list of page requests,write an algorithm to calculate the number of cache misses. A cache miss occurs when a page is requested and isn't found in the cache.

int lruCacheMisses(int num, List pages, int maxCacheSize)
Input
The input consists of three arguments:

num : an integer representing the number of pages

pages : a list of integers representing the pages requested

maxCacheSize : an integer representing the size of the cache

Output
Return an integer for the number of cache misses.

Note
The cache is initially empty and the list contains pages numbered in the range 1-50. A page at index "i" in the list is requested before a page at index "i+1".

Constraints
0 <= i < num

Examples
Example 1:
Input:
num = 6

pages = [1,2,1,3,1,2]

maxCacheSize = 2

Output: 4
Explanation:
Cache state as requests come in ordered longest-time-in-cache to shortest-time-in-cache:

1*

1,2*

2,1

1,3*

3,1

1,2*

Asterisk (*) represents a cache miss. Hence, the total number of a cache miss is 4.

 */
public class LRUCacheMisses {

    public static void main(String[] args) {

        LRUCacheMisses lru = new LRUCacheMisses();

        int[] nums = {1, 2, 1, 3, 1, 2};
        int size = 2;
        System.out.println(lru.solve(nums, size));

    }

    int solve(int[] nums, int maxSize) {
        int cacheMisses = 0;
        LinkedList<Node> list = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();

        for (int i : nums) {

            if (map.containsKey(i)) {
                Node node = map.get(i);
                list.removeFirstOccurrence(node);
                list.addLast(node);
            } else {
                cacheMisses++;
                if (map.size() == maxSize) {
                    Node node = list.removeFirst();
                    map.remove(node.val);
                }
                Node node = new Node(i);
                map.put(i, node);
                list.addLast(node);
            }
        }
        return cacheMisses;
    }

    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
