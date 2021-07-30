package Algorithms.ZigZagConversion;

/**
 * 6. ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * Explanation: P I N A L S I G Y A H R P I Example 3:
 * 
 * Input: s = "A", numRows = 1 Output: "A"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consists of English letters (lower-case and
 * upper-case), ',' and '.'. 1 <= numRows <= 1000
 */

class ZigZagConversion {
    // Linear traversal
    public static String convert1(String s, int numRows) {
        int stringSize = s.length();
        String[] array = new String[numRows];
        if (numRows >= stringSize || numRows < 2)
            return s;
        String result = "";
        int counter = 0;
        boolean forward = true;

        for (int i = 0; i < stringSize; i++) {
            if (array[counter] == null)
                array[counter] = Character.toString(s.charAt(i));
            else
                array[counter] += s.charAt(i);
            if (forward) {
                counter += 1;
                if (counter == numRows - 1)
                    forward = false;
            } else {
                counter -= 1;
                if (counter == 0)
                    forward = true;
            }
        }

        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    // Using string builder and formula
    public static String convert2(String s, int numRows) {
        int stringSize = s.length();
        if (numRows < 2 || stringSize <= numRows)
            return s;
        int nxtInd = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                while (j < stringSize) {
                    sb.append(s.charAt(j));
                    j += nxtInd;
                }
            } else {
                int j = i;
                int addInd = (numRows - 1 - j) * 2;
                while (j < stringSize) {
                    sb.append(s.charAt(j));
                    j += addInd;
                    addInd = nxtInd - addInd;
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert1(s, numRows));
        System.out.println(convert2(s, numRows));
    }
}