
/*
Question:
LeetCode 234 - Palindrome Linked List

Given the head of a singly linked list,

Return true if the linked list is a palindrome,
otherwise return false.

A palindrome means:

- Reading from left to right
- And right to left

both should be exactly same.

Example:

Input:
1 -> 2 -> 2 -> 1

Output:
true

Input:
1 -> 2

Output:
false

Constraint:
Solve it in O(n) time
and O(1) extra space.
 */
import java.util.ArrayList;

public class LinkedListPalendrome {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // Brute Force Approach Time Complexity : O(n) Space Complexity O(n)
    public static boolean BruteForce(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        printList(head);

        boolean ans = isPalindrome(head);
        //boolean result = BruteForce(head);

        System.out.println("Is Palindrome: " + ans);
    }
}

/*
Recap:

1. Find middle using slow and fast pointer.

2. Reverse second half of linked list.

3. Compare first half and reversed second half.

4. If all nodes match -> palindrome.
*/

/*
Reverse Intuition Recap:

1. Current node should point backward
   instead of forward.

2. So we do:
   curr.next = prev

3. Before changing pointer,
   save future node using:
   next = curr.next

4. Move pointers ahead:
   prev = curr
   curr = next
*/