/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (excluding the output array)
 *
 * Computes product of all elements except self
 * without using division.
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // Prefix product: result[i] stores product of elements before index i
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Suffix product variable
        int suffixSum = 1;

        // Multiply suffix product with prefix product
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixSum;
            suffixSum *= nums[i];
        }

        return result;
    }
}