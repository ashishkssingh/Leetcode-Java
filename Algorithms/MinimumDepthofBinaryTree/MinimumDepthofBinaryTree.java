package Algorithms.MinimumDepthofBinaryTree;

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: 2 Example 2:
 * 
 * Input: root = [2,null,3,null,4,null,5,null,6] Output: 5
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 105]. -1000 <= Node.val
 * <= 1000
 */
class MinimumDepthofBinaryTree {
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

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String args[]) {
        Integer[] arr = new Integer[] { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(arr, root, 0);
        System.out.println(minDepth(tree));
    }

    private static TreeNode makeTreeFromArray(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode node = new TreeNode(arr[i]);
            root = node;
            root.left = makeTreeFromArray(arr, root.left, 2 * i + 1);
            root.right = makeTreeFromArray(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}