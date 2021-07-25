package Algorithms.SymmetricTree;

/**
 * 101. Symmetric Tree
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3] Output: true Example 2:
 * 
 * 
 * Input: root = [1,2,2,null,3,null,3] Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000]. -100 <= Node.val
 * <= 100
 * 
 * 
 * Follow up: Could you solve it both recursively and iteratively?
 */
class SymmetricTree {

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

    private static boolean matchtrees(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return (matchtrees(left.left, right.right) && matchtrees(left.right, right.left));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || matchtrees(root.left, root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(arr, root, 0);
        System.out.println(isSymmetric(tree));
    }
}