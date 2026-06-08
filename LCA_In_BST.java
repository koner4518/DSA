/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    /*
     * Time Complexity: O(n)
     *   - In the worst case, every node is visited once
     *
     * Space Complexity: O(h)
     *   - Recursion call stack
     *   - h = height of the tree
     *   - Balanced Tree: O(log n)
     *   - Skewed Tree: O(n)
     *
     * Approach:
     * - If the current node is p or q, return it.
     * - Recursively search in left and right subtrees.
     * - If both sides return non-null, current node is the LCA.
     * - Otherwise, return the non-null result upward.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case: empty tree
        if (root == null) {
            return null;
        }

        // Found either p or q
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);

        // p and q are found in different subtrees
        if (lNode != null && rNode != null) {
            return root;
        }

        // Return whichever side found a node
        if (lNode == null) {
            return rNode;
        }

        return lNode;
    }
}