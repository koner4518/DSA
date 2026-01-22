/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Uses XOR property:
 * - a ^ a = 0
 * - a ^ 0 = a
 * Since every element appears twice except one,
 * XOR of all elements gives the single number.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        // XOR all elements in the array
        for (int num : nums) {
            ans ^= num;
        }

        // Remaining value is the unique element
        return ans;
    }
}
