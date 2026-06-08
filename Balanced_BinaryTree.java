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
     *   - Recursion stack
     *   - h = height of the tree
     *   - Worst case: O(n), Balanced tree: O(log n)
     *
     * A tree is balanced if:
     * |height(left) - height(right)| <= 1 for every node.
     *
     * Optimized Approach:
     * Compute height and balance status together in a single DFS traversal.
     */

    class Info {
        int ht;             // height of subtree
        boolean balanced;   // whether subtree is balanced

        Info(int ht, boolean balanced) {
            this.ht = ht;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root).balanced;
    }

    public Info height(TreeNode root) {

        // Empty tree is balanced with height 0
        if (root == null) {
            return new Info(0, true);
        }

        // Get info from left subtree
        Info lInfo = height(root.left);

        // Get info from right subtree
        Info rInfo = height(root.right);

        // Height of current subtree
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;

        // Current node is balanced if:
        // 1. Left subtree is balanced
        // 2. Right subtree is balanced
        // 3. Height difference <= 1
        boolean balanced =
                lInfo.balanced
                && rInfo.balanced
                && Math.abs(lInfo.ht - rInfo.ht) <= 1;

        return new Info(ht, balanced);
    }
}