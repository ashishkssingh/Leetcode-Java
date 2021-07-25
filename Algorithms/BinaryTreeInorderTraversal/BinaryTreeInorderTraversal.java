package Algorithms.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */

class BinaryTreeInorderTraversal {
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

    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        // Base case for recursion

        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void BT(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                BT(root.left, res);
            }
            if (root.val != null) {
                res.add(root.val);
            }
            if (root.right != null) {
                BT(root.right, res);
            }
        }
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        BT(root, res);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        Integer[] arr = new Integer[] { 1, null, 2, 3 };
        TreeNode root = new TreeNode();
        TreeNode tree = insertLevelOrder(arr, root, 0);
        inorderTraversal(tree, res);
        System.out.println(res);
    }
}