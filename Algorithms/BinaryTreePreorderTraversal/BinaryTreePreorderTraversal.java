package Algorithms.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * 
 * 
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3] Output: [1,2,3] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [1] Output: [1] Example 4:
 * 
 * 
 * Input: root = [1,2] Output: [1,2] Example 5:
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