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
     *   - In the worst case, all nodes may be visited
     *
     * Space Complexity: O(h)
     *   - Recursion call stack
     *   - h = height of the BST
     *   - Balanced BST: O(log n)
     *   - Skewed BST: O(n)
     *
     * Approach:
     * - Use BST properties to prune unnecessary branches.
     * - If root.val < low, only search the right subtree.
     * - If root.val > high, only search the left subtree.
     * - Otherwise, include the current node and search both sides.
     */

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    public void helper(TreeNode root, int low, int high) {

        // Base case
        if (root == null) {
            return;
        }

        // Current node lies within the range
        if (root.val >= low && root.val <= high) {

            helper(root.left, low, high);

            sum += root.val;

            helper(root.right, low, high);
        }

        // Current value is greater than high
        // Only left subtree may contain valid values
        else if (root.val > high) {
            helper(root.left, low, high);
        }

        // Current value is less than low
        // Only right subtree may contain valid values
        else {
            helper(root.right, low, high);
        }
    }
}