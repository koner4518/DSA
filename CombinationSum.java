/*
 * Time Complexity: O(2^n)  (approximate, due to backtracking)
 * Space Complexity: O(target)  (recursion depth + current combination list)
 *
 * Uses backtracking to generate all unique combinations where the chosen numbers sum to the given target.
 */
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        // Sort to enable pruning when nums[i] > target
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, target, 0, curr, result);

        return result;
    }

    private void backtrack(int[] nums, int target, int start,
        List<Integer> curr, List<List<Integer>> result) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(curr)); // make a copy
            return;
        }

        // Try each candidate starting from 'start'
        for (int i = start; i < nums.length; i++) {

            // If current number is greater than remaining target,
            // no need to continue (array is sorted)
            if (nums[i] > target) break;

            // Choose the current number
            curr.add(nums[i]);

            // Reuse the same element, so pass i (not i + 1)
            backtrack(nums, target - nums[i], i, curr, result);

            // Undo the choice (backtrack)
            curr.remove(curr.size() - 1);
        }
    }
}