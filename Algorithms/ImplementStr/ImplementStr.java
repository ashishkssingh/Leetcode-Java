package Algorithms.ImplementStr;

/*
28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
*/

public class ImplementStr {
    public int strStr(String haystack, String needle) {
        int needle_len = needle.length();
        int haystack_len = haystack.length();

        for (int i = 0; i <= (haystack_len - needle_len); i++) {
            String sub = haystack.substring(i, (i + needle_len));
            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        ImplementStr str = new ImplementStr();
        int index = str.strStr(haystack, needle);
        System.out.println(index);

    }
}
