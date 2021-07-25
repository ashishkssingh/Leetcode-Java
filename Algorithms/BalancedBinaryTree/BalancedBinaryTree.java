package Algorithms.BalancedBinaryTree;

/**
 * 110. Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: true Example 2:
 * 
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4] Output: false Example 3:
 * 
 * Input: root = [] Output: true
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000]. -104 <= Node.val
 * <= 104
 * 
 */
class BalancedBinaryTree {
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

    public static TreeNode makeTreeFromArray(Integer[] arr, TreeNode root, int index) {
        if (index < arr.length) {
            TreeNode node = new TreeNode(arr[index]);
            root = node;

            root.left = makeTreeFromArray(arr, root.left, 2 * index + 1);
            root.right = makeTreeFromArray(arr, root.right, 2 * index + 2);
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    public static int calculateDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(calculateDepth(root.left), calculateDepth(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        int lh;

        int rh;

        if (root == null)
            return true;

        lh = calculateDepth(root.left);
        rh = calculateDepth(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 };
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(arr, root, 0);
        printTree(tree);
        System.out.println(isBalanced(tree));
    }
}