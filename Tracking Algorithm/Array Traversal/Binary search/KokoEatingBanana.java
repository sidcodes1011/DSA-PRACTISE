/*
Question:
LeetCode 875 - Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, where the i-th pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her eating speed k (bananas per hour). Each hour, she chooses one pile and eats k bananas from it.
If the pile has less than k bananas, she eats all of them and does not eat any more bananas during that hour.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
*/


public class KokoEatingBanana {

    public static int kokoMinSpeed(int[] piles, int hrs) {

        if (piles == null || piles.length == 0) {
            return 0;
        }

        int minSpeed = 1; // Atleast 1 banana
        int maxSpeed = 0;

        // Piles can be unsorted so tax maxSpeed
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int mid = (minSpeed + maxSpeed) / 2; 

            if (canEat(piles, hrs, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    public static boolean canEat(int[] piles, int h, int speed) {

        int hrs = 0;
        for (int pile : piles) {
            hrs += Math.ceil((double) pile / speed);
        }
        return hrs <= h;
    }

    public static void main(String[] args) {

        int[] piles = { 3, 6, 7, 11 };
        int hrs = 8;

        int result = kokoMinSpeed(piles, hrs);

        System.out.println("The Min speed at which koko can eat all banana is ::: " + result);
    }
}

/*
Recap (Simple):

We are finding the minimum eating speed.

Pick a speed → check if Koko can finish within h hours.

If she can → try smaller speed
If she cannot → increase speed

Apply binary search on range:
1 to max(piles)

*/

