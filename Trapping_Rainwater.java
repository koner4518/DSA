/* Problem: https://leetcode.com/problems/trapping-rain-water/
    Time Complexity: O(n)
    Space Complexity: O(1)
     * Uses two-pointer technique to calculate trapped rainwater by maintaining leftMax and rightMax heights.
*/

class Solution {
    public int trap(int[] height) {

        // Two pointers
        int l = 0, r = height.length - 1;

        // Stores total trapped water
        int result = 0;

        // Maximum heights from left and right
        int lMax = height[l], rMax = height[r];

        // Process until pointers meet
        while (l < r) {

            if (lMax < rMax) {
                // Move left pointer
                l++;

                // Update left maximum height
                lMax = Math.max(lMax, height[l]);

                // Water trapped at current index
                result += lMax - height[l];

            } else {
                // Move right pointer
                r--;

                // Update right maximum height
                rMax = Math.max(rMax, height[r]);

                // Water trapped at current index
                result += rMax - height[r];
            }
        }

        return result;
    }
}