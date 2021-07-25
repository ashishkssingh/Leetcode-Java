package Algorithms.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal Given the root of a binary tree, return the
 * inorder traversal of its nodes' values.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3] Output: [1,3,2] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [1] Output: [1] Example 4:
 * 
 * 
 * Input: root = [1,2] Output: [2,1] Example 5:
 * 
 * 
 * Input: root = [1,null,2] Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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