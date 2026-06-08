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
     *   - Recursive call stack
     *   - h = height of the tree
     *   - Worst case: O(n), Balanced tree: O(log n)
     *
     * Lowest Common Ancestor (LCA):
     * The lowest node that has both p and q as descendants (a node can be a descendant of itself).
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base cases
        if (root == null) return null;

        // Found either p or q
        if (root == p || root == q) return root;

        // Search in left subtree
        TreeNode lPart = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode rPart = lowestCommonAncestor(root.right, p, q);

        // p and q found in different subtrees
        if (lPart != null && rPart != null) {
            return root;
        }

        // Both nodes are in right subtree
        if (lPart == null) {
            return rPart;
        }

        // Both nodes are in left subtree
        if (rPart == null) {
            return lPart;
        }

        return null;
    }
}