package Algorithms.RemoveDuplicatesfromSortedList;

/*
 * 83. Remove Duplicates from Sorted List
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,1,2] Output: [1,2] Example 2:
 * 
 * 
 * Input: head = [1,1,2,3,3] Output: [1,2,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 300]. -100 <= Node.val <=
 * 100 The list is guaranteed to be sorted in ascending order.
 */
class RemoveDuplicatesfromSortedList {
    public static class ListNode {
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

    public static void printLinkedList(ListNode sortedLinkedList) {
        ListNode printll = sortedLinkedList;
        while (printll != null) {
            System.out.print(printll.val);
            System.out.print("->");
            printll = printll.next;
        }
        System.out.print("null");
    }

    public static ListNode linkedListFromArray(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode tail = head;
        for (int i = 1; i < a.length; i++) {
            tail.next = new ListNode(a[i]);
            tail = tail.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode main = new ListNode(head.val);
        ListNode tail = main;
        head = head.next;
        while (head != null) {
            if (head.val != tail.val) {
                tail.next = new ListNode(head.val);
                tail = tail.next;
            }
            head = head.next;
        }
        return main;
    }

    public static void main(String[] args) {
        int[] list = new int[] { 0, 0, 0, 0, 0 };

        ListNode linkedList = linkedListFromArray(list);
        ListNode set = deleteDuplicates(linkedList);

        printLinkedList(set);
    }
}