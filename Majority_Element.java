import java.util.*;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Uses HashMap to count frequency of each element.
 */
class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Find element with freq > n/2
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1; // not required if guaranteed to exist
    }
}