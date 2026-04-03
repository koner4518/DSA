/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Key Idea:
 * - If total gas < total cost → impossible
 * - Otherwise, there exists a valid start
 *
 * Greedy:
 * - If current gas becomes negative, reset start
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totGas = 0, totCost = 0;

        int start = 0;     // potential starting index
        int currGas = 0;   // current fuel balance

        for (int i = 0; i < gas.length; i++) {

            totGas += gas[i];
            totCost += cost[i];

            // Net gas after visiting station i
            currGas += gas[i] - cost[i];

            // If we cannot reach next station
            if (currGas < 0) {

                // Reset and choose next station as new start
                currGas = 0;
                start = i + 1;
            }
        }

        // If total gas is insufficient → no solution
        return (totGas < totCost) ? -1 : start;
    }
}