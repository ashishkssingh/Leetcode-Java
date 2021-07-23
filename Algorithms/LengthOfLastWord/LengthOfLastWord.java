package Algorithms.LengthOfLastWord;

/**
 * 58. Length of Last Word
 * 
 * Given a string s consists of some words separated by spaces, return the
 * length of the last word in the string. If the last word does not exist,
 * return 0.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "Hello World" Output: 5 Example 2:
 * 
 * Input: s = " " Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of only English letters and spaces ' '.
 */

class LengthOfLastWord {
    public int lengthOfLastWordMethod1(String s) {
        String[] word_arr = s.trim().split(" ");
        return word_arr[word_arr.length - 1].length();
    }

    public int lengthOfLastWordMethod2(String s) {
        int n = s.length() - 1;
        int count = 0;
        while (n >= 0) {
            if (s.charAt(n) != ' ')
                count++;
            else if (count > 0)
                return count;
            n--;
        }
        return count;
    }

    public static void main(String args[]) {
        String s = "Hello World";
        LengthOfLastWord last = new LengthOfLastWord();
        System.out.println(last.lengthOfLastWordMethod1(s));
        System.out.println(last.lengthOfLastWordMethod2(s));
    }
}