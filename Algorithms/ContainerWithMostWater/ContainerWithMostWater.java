package Algorithms.ContainerWithMostWater;

/**
 * 11. Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above
 * vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49. Example
 * 2:
 * 
 * Input: height = [1,1] Output: 1 Example 3:
 * 
 * Input: height = [4,3,2,1,4] Output: 16 Example 4:
 * 
 * Input: height = [1,2,1] Output: 2
 * 
 * 
 * Constraints:
 * 
 * n == height.length 2 <= n <= 105 0 <= height[i] <= 104
 */

class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height.length == 2) {
            if (height[0] < height[1]) {
                return height[0];
            } else {
                return height[1];
            }
        }
        int i = 0;
        int j = height.length - 1;
        int result = height[0];

        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, area);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] graph = new int[] { 1, 2, 1 };
        System.out.println(maxArea(graph));
    }
}