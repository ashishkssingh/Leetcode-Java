package Algorithms.MergeSortedArray;

import java.util.Arrays;

class MergeSortedArray {
    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
        return nums1;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            } else {
                nums3[k] = nums2[j];

                j++;
            }
            k++;
        }

        while (i < m) {
            nums3[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            nums3[k] = nums2[j];
            j++;
            k++;
        }
        System.arraycopy(nums3, 0, nums1, 0, m + n);
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 0, 0, 0, 0, 0 };
        int m = 1;
        int[] nums2 = new int[] { 1, 2, 3, 5, 6 };
        int n = 5;

        int[] arr1 = merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(arr2));
    }
}