/*
LeetCode 1011 - Capacity To Ship Packages Within D Days

You are given an array weights where weights[i] represents the weight of the i-th package.
You are also given an integer days representing the number of days within which all packages must be shipped.

Packages must be shipped in order (you cannot rearrange them).

Each day, you load packages onto the ship in sequence until the total weight reaches the ship's capacity.
Once capacity is exceeded, you must ship the remaining packages on the next day.

Return the minimum capacity of the ship such that all packages can be shipped within the given number of days.

Example:
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
*/

public class ShipPacking {

    public static int shipWithinDays(int[] weights, int days) {

        int minCapacity = 0;
        int maxCapacity = 0;

        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        while (minCapacity < maxCapacity) {
            int mid = (minCapacity + maxCapacity) / 2;
            if (isPack(weights, days, mid)) {
                maxCapacity = mid;
            } else {
                minCapacity = mid + 1;
            }
        }
        return minCapacity;
    }

    public static boolean isPack(int[] weights, int days, int mid) {

        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > mid) {
                usedDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return usedDays <= days;
    }

    public static void main(String[] args) {

        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        int result = shipWithinDays(weights, days);
        System.out.println("Minimum capacity required: " + result);
    }
}

/*
 * Recap:
 * 
 * We need to find the MINIMUM ship capacity.
 * 
 * Range of answer = [max(weights) → sum(weights)].
 * 
 * Use Binary Search:
 * Try a capacity → check if we can ship within given days.
 * 
 * If possible → try smaller capacity
 * 
 * If not → increase capacity
 * 
 * Use greedy simulation:
 * Fill ship daily until capacity exceeds → move to next day
 * 
 * Pattern: Binary Search on Answer
 */

