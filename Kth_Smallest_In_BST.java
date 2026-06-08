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
     *   - In the worst case, we may visit all nodes
     *
     * Space Complexity: O(h)
     *   - Recursion stack
     *   - h = height of the BST
     *   - Balanced BST: O(log n)
     *   - Skewed BST: O(n)
     *
     * Approach:
     * - Inorder traversal of a BST gives nodes in sorted (ascending) order.
     * - Count nodes during inorder traversal.
     * - When count becomes k, store the answer.
     */

    int ans = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k) {

        // Base case
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left, k);

        // Current node in sorted order
        count++;

        // Found the kth smallest element
        if (count == k) {
            ans = root.val;
            return;
        }

        // Visit right subtree
        inorder(root.right, k);
    }
}