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
     *   - Recursive call stack
     *   - h = height of tree
     *   - Worst case: O(n), Balanced tree: O(log n)
     *
     * Diameter: Number of edges in the longest path between any two nodes.
     *
     * Compute diameter and height together in a single traversal.
     */

    class Info {
        int dia; // diameter of subtree
        int ht;  // height of subtree

        Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        Info node = diameter(root);
        return node.dia;
    }

    public Info diameter(TreeNode root) {

        // Base case
        if (root == null) {
            return new Info(0, 0);
        }

        // Diameter and height of left subtree
        Info lNode = diameter(root.left);

        // Diameter and height of right subtree
        Info rNode = diameter(root.right);

        // Diameter passing through current node
        int selfDia = lNode.ht + rNode.ht;

        // Maximum diameter among:
        // left subtree, right subtree, current node
        int dia = Math.max(
                Math.max(lNode.dia, rNode.dia),
                selfDia
        );

        // Height of current subtree
        int ht = Math.max(lNode.ht, rNode.ht) + 1;

        return new Info(dia, ht);
    }
}