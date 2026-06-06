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
     *   - Visits each node exactly once
     *
     * Space Complexity: O(h)
     *   - Recursion stack, where h is the height of the tree
     *   - Worst case: O(n), Balanced tree: O(log n)
     *
     * A tree is symmetric if its left and right subtrees
     * are mirror images of each other.
     */

    public boolean isSymmetric(TreeNode root) {

        // Compare left and right subtrees
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null and the other is not
        if (left == null || right == null) {
            return false;
        }

        // Check:
        // 1. Current node values are equal
        // 2. Left subtree of left == Right subtree of right
        // 3. Right subtree of left == Left subtree of right
        return (left.val == right.val)
                && mirror(left.left, right.right)
                && mirror(left.right, right.left);
    }
}