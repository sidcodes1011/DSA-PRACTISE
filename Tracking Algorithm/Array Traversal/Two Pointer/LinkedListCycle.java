/*
Problem:
LeetCode 141 - Linked List Cycle

Given the head of a linked list, determine if the linked list has a cycle in it.

A cycle exists if some node in the list can be reached again by continuously 
following the next pointer.

Return true if there is a cycle, otherwise return false.

Approach:
- Use Two Pointers (Slow & Fast)
- slow moves 1 step at a time
- fast moves 2 steps at a time

- If there is a cycle:
    → slow and fast will eventually meet

- If there is no cycle:
    → fast will reach null

Steps:
1. Initialize slow = head, fast = head
2. Traverse while fast != null and fast.next != null
3. Move:
    slow = slow.next
    fast = fast.next.next
4. If slow == fast → cycle exists
5. If loop ends → no cycle

Time Complexity: O(n)
Space Complexity: O(1)
*/

  
public class LinkedListCycle {


    // This is way to create a linked list structure 
      static class ListNode {
        int val;            // To store actual value 
        ListNode next;      // To store address of object

        ListNode(int x) {    // Constructor to initialize node
            val = x;
            next = null;    // Initially not linked to any node
        }

    }
        public static Boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){

                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {

        // Assigning value to node 
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Mapping or Linking
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Comment below to make it non cycle
        fourth.next = second;

        boolean result = hasCycle(head);
        System.out.println("The cycle in above linked List ::: " + result); 
    }

}

/* 
Recap  : 

Use Floyd’s Cycle Detection (Slow & Fast Pointer)
Slow moves 1 step, Fast moves 2 steps
If there is a cycle → they will meet
If fast reaches null → no cycle
*/
