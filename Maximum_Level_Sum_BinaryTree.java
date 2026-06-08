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
     * Space Complexity: O(w)
     *   - Queue stores nodes of a level
     *   - w = maximum width of the tree
     *   - Worst case: O(n)
     *
     * Approach:
     * - Perform Level Order Traversal (BFS).
     * - Compute the sum of nodes at each level.
     * - Track the level having the maximum sum.
     */

    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int sum = 0;

            level++;

            // Process all nodes of the current level
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            // Update answer if current level has a larger sum
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}