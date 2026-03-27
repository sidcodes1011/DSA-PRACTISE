
/*
Google Interview Question:

Given a positive integer n, determine whether it is a Happy Number.

A number is called happy if by repeatedly replacing it with the sum 
of the squares of its digits, it eventually becomes 1. If the process 
enters a cycle and never reaches 1, then the number is not happy.

Write an efficient function:

    public boolean isHappy(int n)

Follow-up:
Can you detect the cycle without using extra space?
*/

public class HappyNumber {

	public static boolean isHappy(int n) {
	
	    if (n == 1) return true;
        if (n == 4) return false;

        return isHappy(getSum(n));
	}
	
	public static int getSum(int n) {		
		  int sum = 0;
	        while (n > 0) {
	            int digit = n % 10;
	            System.out.println("digit :::"+digit);
	            sum += digit * digit;
	            n /= 10;
	        }
		return sum;
	}
	
	public static void main(String[] args) {
	
		int happynumberCheck = 7;
        System.out.println(isHappy(happynumberCheck));  // true

	}
}

/*
Happy Number Logic:

A number is called happy if repeatedly replacing it with the
sum of squares of its digits eventually becomes 1.

Example:
7 -> 49 -> 97 -> 130 -> 10 -> 1

Approach:
1. Extract each digit using n % 10
2. Add square of each digit
3. Remove last digit using n /= 10
4. Repeat recursively until:
   - n == 1  -> Happy Number
   - n == 4  -> Not Happy (unhappy cycle starts)

Key Point:
All unhappy numbers eventually fall into this loop:
4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4
*/

