package localrun;


/*
Question:
LeetCode 19 - Remove Nth Node From End of List

Given the head of a linked list and an integer n,
remove the nth node from the end of the list
and return the head of the modified list.

Example:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example:
Input: head = [1], n = 1
Output: []
*/

public class RemoveKthNode {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Original List:");
        printList(head);

        int k = 3;

        // Remove 2nd node from end
        head = removeNthFromEnd(head, k);

        System.out.println("After Removing " + k + "th Node From End:");
        printList(head);
    }
}

/*
--------------------------------------------------
Approach (Two Pointer / Slow-Fast Pointer):

1) Create a dummy node before head.
   This helps handle edge cases like deleting the first node.

2) Keep two pointers:
   - slow
   - fast

3) Move fast pointer (n + 1) steps ahead.
   This creates a gap of n nodes between slow and fast.

4) Move both pointers together until fast becomes null.

5) At this point:
   slow will be just BEFORE the node to delete.

6) Remove node using:
   slow.next = slow.next.next;

Time Complexity: O(n)
Space Complexity: O(1)
*/
