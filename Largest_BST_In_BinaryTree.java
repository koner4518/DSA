/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

    /*
     * Time Complexity: O(n)
     *   - Each node is processed exactly once
     *
     * Space Complexity: O(h)
     *   - Recursive call stack
     *   - h = height of the tree
     */

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int largestBst(Node root) {
        return helper(root).size;
    }

    static Info helper(Node root) {

        // Empty tree is a BST of size 0
        if (root == null) {
            return new Info(
                true,
                0,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
            );
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        // Current subtree forms a BST
        if (left.isBST &&
            right.isBST &&
            root.data > left.max &&
            root.data < right.min) {

            return new Info(
                true,
                left.size + right.size + 1,
                Math.min(root.data, left.min),
                Math.max(root.data, right.max)
            );
        }

        // Current subtree is not a BST
        return new Info(
            false,
            Math.max(left.size, right.size),
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        );
    }
}