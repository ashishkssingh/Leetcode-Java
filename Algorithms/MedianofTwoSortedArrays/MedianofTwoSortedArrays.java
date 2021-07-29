package Algorithms.MedianofTwoSortedArrays;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2. Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. Example 3:
 * 
 * Input: nums1 = [0,0], nums2 = [0,0] Output: 0.00000 Example 4:
 * 
 * Input: nums1 = [], nums2 = [1] Output: 1.00000 Example 5:
 * 
 * Input: nums1 = [2], nums2 = [] Output: 2.00000
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n
 * <= 2000 -106 <= nums1[i], nums2[i] <= 106
 */

class MedianofTwoSortedArrays {

    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1 + l2];

        int counter = 0;

        int i = 0;
        int j = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                nums[counter] = nums1[i];
                i++;
            } else {
                nums[counter] = nums2[j];
                j++;
            }
            counter++;
        }
        while (i < l1) {
            nums[counter] = nums1[i];
            i++;
            counter++;
        }
        while (j < l2) {
            nums[counter] = nums2[j];
            j++;
            counter++;
        }
        return nums;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        nums1 = mergeTwoArray(nums1, nums2);
        int mid = nums1.length;

        return (nums1[(int) (mid / 2)] + nums1[(int) ((mid - 1) / 2)]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4 };

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}