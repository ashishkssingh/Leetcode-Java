package Algorithms.LongestSubstring;

import java.util.Arrays;
import java.util.HashMap;

/*
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class LongestSubsringWithoutRepeating {
    // Using Hashmap
    public int lengthOfLongestSubstring1(String s) {

        int length = s.length();
        int maxLength = 0;
        if ((length <= 1) || (length == 2 && s.charAt(0) != s.charAt(1)))
            return length;
        else {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int start = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    start = Math.max(start, map.get(c) + 1);
                }
                map.put(c, i);
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }

        return maxLength;
    }

    // Same logic using 256 char array
    public int lengthOfLongestSubstring2(String s) {

        int length = s.length();
        int maxLength = 0;
        int[] indexArray = new int[length];

        for (int i = 0; i < length; i++) {
            indexArray[i] = s.charAt(i);
        }
        System.out.println(Arrays.toString(indexArray));

        int start = 0;
        int[] lastIndexArray = new int[256];
        for (int i = 0; i < length; i++) {
            if (lastIndexArray[indexArray[i]] > 0) {
                start = Math.max(start, lastIndexArray[indexArray[i]]);
            }
            lastIndexArray[indexArray[i]] = i + 1;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        System.out.println(Arrays.toString(lastIndexArray));

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubsringWithoutRepeating longSub = new LongestSubsringWithoutRepeating();
        System.out.println(longSub.lengthOfLongestSubstring2("abcabcbb"));

    }
}