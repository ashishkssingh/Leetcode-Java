package Algorithms.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * 
 */
class BinaryTreePreorderTraversal {
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
        // Base case for recursion

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

    public static void BT(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.val != null) {
                res.add(root.val);
            }
            if (root.left != null) {
                BT(root.left, res);
            }
            if (root.right != null) {
                BT(root.right, res);
            }
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root, List<Integer> res) {
        BT(root, res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        Integer[] array = new Integer[] { 1, null, 2, 3 };
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(array, root, 0);
        preorderTraversal(tree, res);
        System.out.println(res);
    }
}