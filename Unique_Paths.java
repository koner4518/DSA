/*
 * Time Complexity: O(min(m, n))
 * Space Complexity: O(1)
 *
 * Uses combinatorics:
 * Total moves = (m - 1) downs + (n - 1) rights
 * Answer = C(m + n - 2, m - 1) or C(m + n - 2, n - 1)
 */
class Solution {
    public int uniquePaths(int m, int n) {

        // Total number of moves
        int N = m + n - 2;

        // We choose the smaller value to minimize iterations
        int r = Math.min(m - 1, n - 1);

        // Use long to avoid overflow during intermediate calculations
        long res = 1;

        // Compute nCr using iterative multiplication
        // C(N, r) = (N - r + 1)/1 * (N - r + 2)/2 * ... * N/r
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }

        return (int) res;
    }
}