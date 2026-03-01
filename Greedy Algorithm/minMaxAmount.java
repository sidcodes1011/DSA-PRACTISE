// Question - candy store problem

// In a candy store, there are different types of candies available and prices[i] represent the price of  ith types of candies. You are now provided with an attractive offer.
// For every candy you buy from the store, you can get up to k other different candies for free. Find the minimum and maximum amount of money needed to buy all the candies.
// Note: In both cases, you must take the maximum number of free candies possible during each purchase.

import java.util.Arrays;

public class minMaxAmount {

    public static void main(String[] args) {
        
        System.out.println("DSA Min or max amount");

        int[] prices = {3, 2, 1, 4};
        int k = 2;
        int n = prices.length;
        System.out.println("Size of price array ::"+n);
        Arrays.sort(prices);        
        // Minimum cost
        int minCost = 0;
        int buy = 0;       // Points to the candy we are paying for
        int free = n - 1;  //Represents the last candy still remaining
        while (buy <= free) {
            minCost += prices[buy];
            buy++;
            free -= k;
        }
        // Maximum cost
        int maxCost = 0;
        buy = n - 1;
        free = 0;
        while (buy >= free) {
            maxCost += prices[buy];
            buy--;
            free += k;
        }
        System.out.println("Minimum cost = " + minCost);
        System.out.println("Maximum cost = " + maxCost);

    }
}
