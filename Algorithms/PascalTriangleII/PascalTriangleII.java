package Algorithms.PascalTriangleII;

/**
 * 119. Pascal's Triangle II
 * 
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * 
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * 
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */

import java.util.ArrayList;
import java.util.List;

class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String args[]) {
        int index = 3;
        List<Integer> row = getRow(index);
        System.out.println(row.toString());
    }
}