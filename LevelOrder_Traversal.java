import java.util.*;

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
     * Space Complexity: O(n)
     *   - Queue may store up to one level of nodes
     *
     * Uses Breadth-First Search (BFS) to traverse the tree level by level.
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();

        q.add(root);
        q.add(null); // Marks end of current level

        while (!q.isEmpty()) {

            TreeNode temp = q.poll();

            // End of a level
            if (temp == null) {

                list.add(l);

                if (q.isEmpty()) {
                    break;
                }

                q.add(null); // Mark next level end
                l = new ArrayList<>();

            } else {

                l.add(temp.val);

                // Add left child
                if (temp.left != null) {
                    q.add(temp.left);
                }

                // Add right child
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        return list;
    }
}