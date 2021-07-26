package Algorithms.PascalTriangle;

/**
 * 118. Pascal's Triangle
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * 
  * 
 * 
 * Example 1:
 * 
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:

 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 */

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> row = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> column = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    column.add(1);
                } else {
                    column.add(row.get(i - 1).get(j - 1) + row.get(i - 1).get(j));
                }
            }
            row.add(column);
        }
        return row;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void printPascalTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle1 = generate1(numRows);
        printPascalTriangle(triangle1);

        System.out.println();

        List<List<Integer>> triangle2 = generate2(numRows);
        printPascalTriangle(triangle2);
    }
}