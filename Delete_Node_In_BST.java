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
     * Time Complexity: O(h)
     *   - h = height of the BST
     *   - Searching for the node and finding the inorder successor
     *
     * Space Complexity: O(h)
     *   - Recursive call stack
     *   - Balanced BST: O(log n)
     *   - Skewed BST: O(n)
     *
     * Cases while deleting a node:
     * 1. Leaf Node      -> Simply remove it
     * 2. One Child      -> Replace node with its child
     * 3. Two Children   -> Replace with inorder successor and delete the successor
     */
    public TreeNode inOrderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        // Node not found
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        // Search in right subtree
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child exists
            else if (root.left == null) {
                return root.right;
            }

            // Case 2: Only left child exists
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            TreeNode insucc = inOrderSuccessor(root.right);

            // Replace current node's value
            // with inorder successor's value
            root.val = insucc.val;

            // Delete the inorder successor
            root.right = deleteNode(root.right, insucc.val);
        }

        return root;
    }
}