// Basic Recursion 
// Question - 2) Calculate factorial on n using recursion 

public class nFactorialRecursion {

    static int factorial(int n) {
        if (n < 1) {
            return 1;
        }
        return n * factorial((n - 1));
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Result ::: " + factorial(n));
    }
}

// How recursion works internally
// Forward recursion phase (calls going deeper)
// factorial(5)
// = 5 * factorial(4)
// = 5 * (4 * factorial(3))
// = 5 * (4 * (3 * factorial(2)))
// = 5 * (4 * (3 * (2 * factorial(1))))
// = 5 * (4 * (3 * (2 * (1 * factorial(0)))))
// Base case
// factorial(0) = 1
// Stack unwinding phase (returning values)
// = 5 * (4 * (3 * (2 * (1 * 1))))
// = 5 * (4 * (3 * (2 * 1)))
// = 5 * (4 * (3 * 2))
// = 5 * (4 * 6)
// = 5 * 24
// = 120
