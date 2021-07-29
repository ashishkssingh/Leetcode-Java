package Algorithms.LongestPalindromicSubstring;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer. Example
 * 2:
 * 
 * Input: s = "cbbd" Output: "bb" Example 3:
 * 
 * Input: s = "a" Output: "a" Example 4:
 * 
 * Input: s = "ac" Output: "a"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consist of only digits and English letters
 * (lower-case and/or upper-case),
 */

class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == "" || s.length() < 1)
            return "";
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i != chars.length; ++i) {
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(char[] chars, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String args[]) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}