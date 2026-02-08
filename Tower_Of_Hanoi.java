/*
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)   (recursive call stack)
 *
 * Returns the total number of moves required to shift n disks from 'from' rod to 'to' rod using 'aux' rod.
 */
class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {

        // Base case: only one disk, only one move needed
        if (n == 1) return 1;

        // Moves to shift (n-1) disks from 'from' to 'aux'
        // + 1 move to shift the largest disk from 'from' to 'to'
        // + Moves to shift (n-1) disks from 'aux' to 'to'
        return towerOfHanoi(n - 1, from, aux, to) + 1 + towerOfHanoi(n - 1, aux, to, from);
    }
}