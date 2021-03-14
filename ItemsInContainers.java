package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.Arrays;

/*

A company would like to know how much inventory exists in their closed inventory compartments.

Gwen a string s consisting of items as * and closed compartments as an open and close |, an array of starting indices startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments within the substring between the two indices, inclusive.

An item is represented as an asterisk ( * = ascii decimal 42)
A compartment is represented as a pair of pipes that may or may not have items between them ( | = ascii decimal 124).
Example 1:
Input: s = |**|*|*, startIndices = [1, 1], endIndices = [5, 6]
Output: [2, 3]
Explanation:
The string has a total of 2 closed compartments, one with 2 items and one with 1 item.

For the first pair of indices, (1, 5), the substring |**|*. There are 2 items in a compartment.

For the second pair of indices, (1, 6), the substring is |**|*| and there are 2 + 1 = 3 items in compartments.

Both of the answers are returned in an array, [2, 3]

Example 2:
Input: s = *|*|, startIndices = [1], endIndices = [3]
Output: []
Explanation:
the substring from index = 1 to index = 3 is *|*. There is no compartments in this string.

Constraints:
1 <= m, n <= 10^5
1 <= startIndices[i] <= endIndices[i] <= n
Each character or s is either * or |

 */
public class ItemsInContainers {


    public static void main(String[] args) {

        String s = "*|**|*|*";
        int[] startIndices = {1, 1};
        int[] endIndices = {6, 8};

        System.out.println(Arrays.toString(solve(s, startIndices, endIndices)));
        System.out.println(Arrays.toString(revSolve(s, startIndices, endIndices)));


    }

    static int [] revSolve(String s, int [] start, int [] end){

        int [] pre = new int[s.length()];

        int track =0, temp =0;
        boolean firstCheck = false;


        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c=='|'){

                track = temp;

                if(!firstCheck) firstCheck = true;

            }else if(c=='*' && firstCheck){
                temp = temp+1;
            }
            pre[i] = track;
        }

        int [] ans = new int[start.length];

        for(int i=0;i<start.length;i++){
            ans[i] = pre[end[i]-1] - pre[start[i]-1];
        }
        return ans;

    }

    static int[] solve(String s, int[] start, int[] end) {


        int[] pre = new int[s.length()];

        int track = 0, temp = 0;
        boolean startFlag = false;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                track = temp;
                if (!startFlag)
                    startFlag = true; // to track first piller

            } else if (c == '*' && startFlag) {
                temp = temp + 1;
            }
            pre[i] = track;
        }
        int[] ans = new int[start.length];

        System.out.println(Arrays.toString(pre));
        for (int i = 0; i < start.length; i++) {
            ans[i] = pre[end[i] - 1] - pre[start[i] - 1];
        }
        return ans;


    }
}
