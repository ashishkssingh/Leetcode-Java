package Algorithms.ValidPalindrome;

/**
 * 125. Valid Palindrome
 * 
 * Given a string s, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
 * "amanaplanacanalpanama" is a palindrome. Example 2:
 * 
 * Input: s = "race a car" Output: false Explanation: "raceacar" is not a
 * palindrome.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 105 s consists only of printable ASCII characters.
 */
class ValidPalindrome {
    public static boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (Character.isLetterOrDigit(s.charAt(i)) == false) {
                i++;
            } else if (Character.isLetterOrDigit(s.charAt(j)) == false) {
                j--;
            } else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j;) {
            if (!Character.isLetterOrDigit(c[i]))
                i++;
            else if (!Character.isLetterOrDigit(c[j]))
                j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));
        System.out.println(isPalindrome2(s));
    }
}