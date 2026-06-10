/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /*
     * Time Complexity: O(n)
     *   - Each node is visited exactly once
     *
     * Space Complexity: O(h)
     *   - Recursion call stack
     *   - h = height of the BST
     *   - Balanced BST: O(log n)
     *   - Skewed BST: O(n)
     *
     * Approach:
     * - Inorder traversal of a BST gives nodes in sorted order.
     * - The minimum difference can only occur between two consecutive nodes in this order.
     * - Keep track of the previous visited node and update the minimum difference.
     */

    int minDiff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left);

        // Update minimum difference with previous node
        if (prev != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        // Update previous node value
        prev = root.val;

        // Visit right subtree
        inorder(root.right);
    }
}