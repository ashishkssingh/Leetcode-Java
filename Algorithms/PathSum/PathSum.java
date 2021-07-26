package Algorithms.PathSum;

/**
 * Definition for a binary tree node.
 * 
 */
class PathSum {
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

    public static TreeNode makeTreeFromArray(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode node = new TreeNode(arr[i]);
            root = node;

            root.left = makeTreeFromArray(arr, root.left, 2 * i + 1);
            root.right = makeTreeFromArray(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static boolean hasPathSum(TreeNode root, Integer targetSum) {
        if (root == null)
            return false;
        if ((root.val == targetSum) && (root.left == null) && (root.right == null))
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
        Integer targetSum = 22;
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(arr, root, 0);
        System.out.println(hasPathSum(tree, targetSum));
    }
}