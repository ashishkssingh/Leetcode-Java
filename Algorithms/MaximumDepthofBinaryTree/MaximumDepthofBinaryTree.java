package Algorithms.MaximumDepthofBinaryTree;

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