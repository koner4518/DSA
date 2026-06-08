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
     * Time Complexity: O(n * m)
     *   - n = number of nodes in root
     *   - m = number of nodes in subRoot
     *   - For each node in root, we may compare the entire subRoot
     *
     * Space Complexity: O(h1 + h2)
     *   - h1 = height of root
     *   - h2 = height of subRoot
     *   - Due to recursion stack
     *
     * Idea:
     * - Traverse the main tree.
     * - Whenever a node matches subRoot's value,
     *   check if both trees are identical.
     * - If not, continue searching in left and right subtrees.
     */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // Main tree exhausted
        if (root == null) return false;

        // Potential starting point found
        if (root.val == subRoot.val) {

            // Check if both trees are identical
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Search in left and right subtrees
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {

        // Both trees are empty
        if (root == null && subRoot == null) {
            return true;
        }

        // One tree is empty, the other is not
        if (root == null || subRoot == null) {
            return false;
        }

        // Current values must match and
        // left & right subtrees must also match
        return (root.val == subRoot.val)
                && isIdentical(root.left, subRoot.left)
                && isIdentical(root.right, subRoot.right);
    }
}