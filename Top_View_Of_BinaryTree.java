import java.util.*;

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
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
     * For Top View:
     * - Store only the first node encountered at each HD.
     * - BFS ensures the topmost node is visited first.
     */

    class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root, 0));

        while (!q.isEmpty()) {

            Info curr = q.poll();

            // Store first node seen at this HD
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

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

        // Traverse HDs from leftmost to rightmost
        for (int i = min; i <= max; i++) {
            list.add(map.get(i).data);
        }

        return list;
    }
}