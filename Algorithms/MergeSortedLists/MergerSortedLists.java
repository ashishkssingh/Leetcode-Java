package Algorithms.MergeSortedLists;

/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.

 */
class MergeSortedLists {
    public class ListNode {
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

    public void printLinkedList(ListNode sortedLinkedList) {
        ListNode printll = sortedLinkedList;
        while (printll != null) {
            System.out.print(printll.val);
            System.out.print("->");
            printll = printll.next;
        }
        System.out.print("null");
    }

    public ListNode linkedListFromArray(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode tail = head;
        for (int i = 1; i < a.length; i++) {
            tail.next = new ListNode(a[i]);
            tail = tail.next;
        }
        return head;
    }

    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 1, 2, 4 };
        int[] l2 = new int[] { 1, 3, 4 };

        MergeSortedLists msl = new MergeSortedLists();

        ListNode ll1 = msl.linkedListFromArray(l1);
        ListNode ll2 = msl.linkedListFromArray(l2);

        ListNode iMergeList = msl.mergeTwoListsIterative(ll1, ll2);
        msl.printLinkedList(iMergeList);

        System.out.println();

        ListNode rMergeList = msl.mergeTwoListsRecursive(ll1, ll2);
        msl.printLinkedList(rMergeList);

        System.out.println();

    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l2;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }
}