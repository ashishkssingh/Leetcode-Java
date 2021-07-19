package Algorithms.LongestCommonPrefix;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/

public class LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs) {

        if (strs.length == 0 || strs == null)
            return "";

        if (strs.length == 1)
            return strs[0];

        String lcp = "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                lcp += first.charAt(i);
            } else
                break;
        }
        return lcp;
    }

    public String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0 || strs == null)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {

        String[] str = new String[] { "flower", "flow", "flight" };

        LongestCommonPrefix longC = new LongestCommonPrefix();
        System.out.println(longC.longestCommonPrefix2(str));
    }

}
