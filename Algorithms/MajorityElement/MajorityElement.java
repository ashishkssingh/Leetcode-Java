package Algorithms.MajorityElement;

import java.util.HashMap;

/**
 * 169. Majority Element
 * 
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3] Output: 3 Example 2:
 * 
 * Input: nums = [2,2,1,1,1,2,2] Output: 2
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= n <= 5 * 104 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                count++;
                if (count > n / 2)
                    return nums[i];

                map.put(nums[i], count);
            } else
                map.put(nums[i], 1);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }
}