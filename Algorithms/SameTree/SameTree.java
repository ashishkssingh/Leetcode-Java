package Algorithms.SameTree;

/**
 * Definition for a binary tree node.
 */
class SameTree {
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
            TreeNode temp = new TreeNode(arr[index]);
            root = temp;
            root.left = makeTreeFromArray(arr, root.left, 2 * index + 1);
            root.right = makeTreeFromArray(arr, root.right, 2 * index + 1);
        }
        return root;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] { 1, 2, 3 };
        Integer[] arr2 = new Integer[] { 1, 2, 3 };

        TreeNode root1 = new TreeNode();
        TreeNode tree1 = makeTreeFromArray(arr1, root1, 0);

        TreeNode root2 = new TreeNode();
        TreeNode tree2 = makeTreeFromArray(arr2, root2, 0);

        System.out.println(isSameTree(tree1, tree2));

    }
}