import java.util.*;

/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    /*
     * Time Complexity: O(n)
     *   - Each node is visited exactly once
     *
     * Space Complexity: O(n)
     *   - Queue + HashMap
     *
     * Uses Level Order Traversal (BFS) with Horizontal Distance (HD).
     *
     * HD Rules:
     * - Root -> 0
     * - Left Child -> HD - 1
     * - Right Child -> HD + 1
     *
     * For Bottom View:
     * - Keep updating the node at each HD.
     * - The last node encountered at an HD will be visible from the bottom.
     */

    class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {

            Info curr = q.poll();

            // Store latest node for this HD
            map.put(curr.hd, curr.node);

            // Process left child
            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            // Process right child
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Traverse HDs from leftmost to rightmost
        for (int i = min; i <= max; i++) {
            list.add(map.get(i).data);
        }

        return list;
    }
}