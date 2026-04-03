import java.util.*;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Uses Prefix Sum + HashMap.

 * If same prefix sum occurs at two indices, the subarray between them has sum = 0.
 */
class Solution {
    int maxLength(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;  // prefix sum
        int len = 0;  // max length

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If prefix sum becomes 0 → subarray from 0 to i
            if (sum == 0) {
                len = i + 1;
            }

            // Store first occurrence of prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } 
            else {
                // If seen before → subarray with sum 0 exists
                len = Math.max(len, i - map.get(sum));
            }
        }

        return len;
    }
}