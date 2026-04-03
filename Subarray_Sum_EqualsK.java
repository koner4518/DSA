import java.util.*;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Uses Prefix Sum + HashMap
 * If (currentSum - k) exists before, then a subarray with sum = k is found.
 */
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;  // prefix sum
        int ans = 0;  // number of subarrays

        // Base case: prefix sum 0 occurs once
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // Check if there exists a prefix with sum = (sum - k)
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            // Store current prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}