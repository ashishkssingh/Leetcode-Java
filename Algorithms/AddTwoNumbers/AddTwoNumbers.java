package Algorithms.AddTwoNumbers;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

import java.util.Arrays;

public class AddTwoNumbers {

    // Static class defining Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // LeetCode Problem Solution
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;

            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            current.next = node;
            current = current.next;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;

        }

        return dummy.next;
    }

    // Get size of Linked list when we dont know size
    private static int linked_list_size(ListNode ll) {
        int counter = 0;
        while (ll != null) {
            counter += 1;
            ll = ll.next;
        }
        return counter;
    }

    // Function to convert Linked List to array for printing
    private static int[] linked_list_to_array(ListNode sum_ll) {
        int[] printArray = new int[linked_list_size(sum_ll)];
        int counter = 0;
        while (sum_ll != null) {
            printArray[counter] = sum_ll.val;
            sum_ll = sum_ll.next;
            counter += 1;
        }
        return printArray;
    }

    // Function to convert a array to LinkedList
    private static ListNode arrayToList(int[] ll) {
        ListNode head = new ListNode(ll[0]);
        ListNode tail = head;
        for (int i = 1; i < ll.length; i++) {
            ListNode node = new ListNode(ll[i]);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }

    // Main Function
    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 9, 9, 9, 9, 9, 9 };
        int[] l2 = new int[] { 9, 9, 9, 9, 9 };

        ListNode ll1 = arrayToList(l1);
        ListNode ll2 = arrayToList(l2);

        AddTwoNumbers add = new AddTwoNumbers();
        ListNode ll_sum = add.addTwoNumbers(ll1, ll2);
        System.out.println(Arrays.toString(linked_list_to_array(ll_sum)));
    }
}