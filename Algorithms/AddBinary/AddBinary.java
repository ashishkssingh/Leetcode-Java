package Algorithms.AddBinary;

/**
 * 67. Add Binary
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself. 
 * */

import java.math.BigInteger;

class AddBinary {
    // Lazy Solution
    public String addBinary1(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        return (num1.add(num2)).toString(2);
    }

    // Logical Solution
    public String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        String result = "";

        while (i >= 0 || j >= 0 || sum == 1) {
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);

            result = (char) (sum % 2 + '0') + result;

            sum /= 2;

            i--;
            j--;
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "11";
        AddBinary add = new AddBinary();
        // System.out.println(add.addBinary1(a, b));
        System.out.println(add.addBinary2(a, b));
    }
}