
/*
    Question:
    Reverse a singly linked list.

    Given:
    1 -> 2 -> 3 -> 4 -> null

    Return:
    4 -> 3 -> 2 -> 1 -> null

    Constraint:
    Solve it using iterative approach.
 */
public class ReverseLinkedList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Print Linked List
    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    // Reverse Linked List
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

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode reversedHead = reverse(head);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}

/*
Reverse Linked List Recap:

1. We want every node
   to point backward instead of forward.

   Original:
   1 -> 2 -> 3

   Reversed:
   3 -> 2 -> 1

2. Current node should point
   to previous node.

   So:
   curr.next = prev

3. Before changing pointer,
   save future node first.

   So:
   next = curr.next

4. After reversing current node,
   move pointers ahead.

   prev = curr
   curr = next

5. Continue until curr becomes null.

6. prev becomes new head
   of reversed linked list.
 */
