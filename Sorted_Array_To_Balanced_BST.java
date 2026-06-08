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
     *   - Each element is used exactly once to create a tree node
     *
     * Space Complexity: O(log n)
     *   - Recursive call stack for a balanced BST
     *   - Worst case: O(n) if recursion becomes skewed
     *
     * Approach:
     * - Since the array is sorted, choose the middle element as the root to keep the tree balanced.
     * - Recursively build the left subtree from the left half.
     * - Recursively build the right subtree from the right half.
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int st, int end) {

        // No elements left to process
        if (st > end) {
            return null;
        }

        // Choose middle element as root
        int mid = (st + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree from left half
        root.left = helper(nums, st, mid - 1);

        // Build right subtree from right half
        root.right = helper(nums, mid + 1, end);

        return root;
    }
}