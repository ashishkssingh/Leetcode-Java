package Algorithms.MaximumDepthofBinaryTree;

/**
 * 104. Maximum Depth of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: 3 Example 2:
 * 
 * Input: root = [1,null,2] Output: 2 Example 3:
 * 
 * Input: root = [] Output: 0 Example 4:
 * 
 * Input: root = [0] Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. -100 <= Node.val <=
 * 100
 */

class MaximumDepthofBinaryTree {
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

    private static TreeNode makeTreeFromArray(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = makeTreeFromArray(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = makeTreeFromArray(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String args[]) {
        Integer[] array = new Integer[] { 3, 9, 20, null, null, 15, 7 };

        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(array, root, 0);
        System.out.println(maxDepth(tree));
    }

}