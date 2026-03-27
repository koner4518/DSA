/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Uses Floyd’s Cycle Detection (Tortoise & Hare).
 * Duplicate number forms a cycle in this structure.
 */
class Solution {
    public int findDuplicate(int[] nums) {

        // Step 1: Find intersection point inside the cycle
        int slow = 0, fast = 0;

        while (true) {
            slow = nums[slow];           // move 1 step
            fast = nums[nums[fast]];     // move 2 steps

            if (slow == fast) break;     // cycle detected
        }

        // Step 2: Find entry point of cycle (duplicate number)
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}