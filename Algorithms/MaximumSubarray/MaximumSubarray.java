package Algorithms.MaximumSubarray;

/**
 * 53. Maximum Subarray Given an integer array nums, find the contiguous
 * subarray (containing at least one number) which has the largest sum and
 * return its sum.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
 * the largest sum = 6. Example 2:
 * 
 * Input: nums = [1] Output: 1 Example 3:
 * 
 * Input: nums = [5,4,-1,7,8] Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -105 <= nums[i] <= 105
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 */

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int global_sum = nums[0];
        int local_sum = nums[0];

        for (int i = 1; i < n; i++) {
            local_sum = Math.max(nums[i], local_sum + nums[i]);
            if (global_sum < local_sum)
                global_sum = local_sum;

        }
        System.gc();
        return global_sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        MaximumSubarray max = new MaximumSubarray();
        System.out.println(max.maxSubArray(nums));
    }
}