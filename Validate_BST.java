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
     *   - h = height of the tree
     *   - Balanced Tree: O(log n)
     *   - Skewed Tree: O(n)
     *
     * Approach:
     * - Every node must lie within a valid range.
     * - Left subtree nodes must be smaller than the current node.
     * - Right subtree nodes must be greater than the current node.
     * - Pass the allowed minimum and maximum boundaries while traversing the tree.
     */

    public boolean isValidBST(TreeNode root) {
        return validBst(root, null, null);
    }

    public boolean validBst(TreeNode root, TreeNode min, TreeNode max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Current node must be greater than min boundary
        if (min != null && root.val <= min.val) {
            return false;
        }

        // Current node must be smaller than max boundary
        if (max != null && root.val >= max.val) {
            return false;
        }

        // Validate left and right subtrees with updated boundaries
        return validBst(root.left, min, root)
                && validBst(root.right, root, max);
    }
}