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
     *   - Inorder traversal: O(n)
     *   - Rebuilding balanced BST: O(n)
     *
     * Space Complexity: O(n)
     *   - ArrayList stores all node values
     *   - Recursive call stack: O(h)
     *
     * Approach:
     * 1. Perform inorder traversal of BST.
     *    -> Produces values in sorted order.
     * 2. Build a balanced BST from the sorted array.
     *    -> Choose middle element as root.
     *    -> Recursively build left and right subtrees.
     */

    public TreeNode balanceBST(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        // Store BST values in sorted order
        inorder(root, list);

        // Build balanced BST from sorted values
        return convertBalanceBST(list, 0, list.size() - 1);
    }

    public TreeNode convertBalanceBST(ArrayList<Integer> list, int st, int end) {

        // No nodes left to process
        if (st > end) {
            return null;
        }

        // Choose middle element as root
        int mid = (st + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        // Build left subtree
        root.left = convertBalanceBST(list, st, mid - 1);

        // Build right subtree
        root.right = convertBalanceBST(list, mid + 1, end);

        return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        // Left subtree
        inorder(root.left, list);

        // Current node
        list.add(root.val);

        // Right subtree
        inorder(root.right, list);
    }
}