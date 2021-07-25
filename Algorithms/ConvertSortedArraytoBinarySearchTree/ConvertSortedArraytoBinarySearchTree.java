package Algorithms.ConvertSortedArraytoBinarySearchTree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5] Explanation:
 * [0,-10,5,null,-3,null,9] is also accepted:
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3] Output: [3,1] Explanation: [1,3] and [3,1] are both a
 * height-balanced BSTs.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -104 <= nums[i] <= 104 nums is sorted in a strictly
 * increasing order.
 */

class ConvertSortedArraytoBinarySearchTree {
    public static class TreeNode {

        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode BSTHelper(Integer[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[middle]);

        node.left = BSTHelper(nums, left, middle - 1);
        node.right = BSTHelper(nums, middle + 1, right);

        return node;
    }

    public static TreeNode sortedArrayToBST(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return BSTHelper(nums, 0, nums.length - 1);
    }

    private static void printInOrderTree(TreeNode root) {
        if (root != null) {
            printInOrderTree(root.left);
            System.out.println(root.val);
            printInOrderTree(root.right);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { -10, -3, 0, 5, 9 };
        TreeNode tree = sortedArrayToBST(arr);
        printInOrderTree(tree);
    }
}