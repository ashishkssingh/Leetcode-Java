package Algorithms.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * 
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3] Output: [3,2,1] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [1] Output: [1] Example 4:
 * 
 * 
 * Input: root = [1,2] Output: [2,1] Example 5:
 * 
 * 
 * Input: root = [1,null,2] Output: [2,1]
 * 
 * 
 * Constraints:
 * 
 * The number of the nodes in the tree is in the range [0, 100]. -100 <=
 * Node.val <= 100
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */
class BinaryTreePostorderTraversal {
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

    public static void BT(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                BT(root.left, res);
            }
            if (root.right != null) {
                BT(root.right, res);
            }
            if (root.val != null) {
                res.add(root.val);
            }
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root, List<Integer> res) {
        BT(root, res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        Integer[] arr = new Integer[] { 1, null, 2, 3 };
        TreeNode root = new TreeNode();
        TreeNode tree = makeTreeFromArray(arr, root, 0);
        postorderTraversal(tree, res);
        System.out.println(res);
    }
}