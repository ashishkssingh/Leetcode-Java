package Algorithms.IntersectionofTwoLinkedLists;

import java.util.HashSet;

/**
 * 160. Intersection of Two Linked Lists
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * 
 * For example, the following two linked lists begin to intersect at node c1:
 * 
 * 
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the
 * function returns.
 * 
 * Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given these
 * inputs):
 * 
 * intersectVal - The value of the node where the intersection occurs. This is 0
 * if there is no intersected node. listA - The first linked list. listB - The
 * second linked list. skipA - The number of nodes to skip ahead in listA
 * (starting from the head) to get to the intersected node. skipB - The number
 * of nodes to skip ahead in listB (starting from the head) to get to the
 * intersected node. The judge will then create the linked structure based on
 * these inputs and pass the two heads, headA and headB to your program. If you
 * correctly return the intersected node, then your solution will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA =
 * 2, skipB = 3 Output: Intersected at '8' Explanation: The intersected node's
 * value is 8 (note that this must not be 0 if the two lists intersect). From
 * the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as
 * [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are
 * 3 nodes before the intersected node in B. Example 2:
 * 
 * 
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1 Output: Intersected at '2' Explanation: The intersected node's
 * value is 2 (note that this must not be 0 if the two lists intersect). From
 * the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as
 * [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node
 * before the intersected node in B. Example 3:
 * 
 * 
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection Explanation: From the head of A, it reads as [2,6,4].
 * From the head of B, it reads as [1,5]. Since the two lists do not intersect,
 * intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes of listA is in the m. The number of nodes of listB is in
 * the n. 0 <= m, n <= 3 * 104 1 <= Node.val <= 105 0 <= skipA <= m 0 <= skipB
 * <= n intersectVal is 0 if listA and listB do not intersect. intersectVal ==
 * listA[skipA] == listB[skipB] if listA and listB intersect.
 * 
 * 
 * Follow up: Could you write a solution that runs in O(n) time and use only
 * O(1) memory?
 * 
 */
public class IntersectionofTwoLinkedLists {
    public static class ListNode {
        Integer val;
        ListNode next;

        ListNode(Integer x) {
            val = x;
            next = null;
        }
    }

    // Linear traversal solution.
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode node = headA;
        int l1 = 0;
        while (node != null) {
            l1++;
            node = node.next;
        }

        int l2 = 0;
        node = headB;
        while (node != null) {
            l2++;
            node = node.next;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        if (l1 < l2) {
            nodeA = headB;
            nodeB = headA;
        }

        for (int i = 0; i < Math.abs(l1 - l2); i++) {
            nodeA = nodeA.next;
        }

        while (nodeA != null && nodeB != null) {

            if (nodeA == nodeB) {
                return nodeA;
            }

            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return new ListNode(null);
    }

    // HashSet Solution
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        HashSet<ListNode> hs = new HashSet<ListNode>();
        while (headA != null) {
            hs.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hs.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return new ListNode(null);
    }

    public static void main(String[] args) {
        // 4,1,8,4,5
        ListNode headA = new ListNode(4);
        ListNode tailA = headA;
        // 5,6,1,8,4,5
        ListNode headB = new ListNode(5);
        ListNode tailB = headB;

        tailB.next = new ListNode(6);

        tailA.next = tailB.next.next = new ListNode(1);
        tailA.next.next = tailB.next.next.next = new ListNode(8);
        tailA.next.next.next = tailB.next.next.next.next = new ListNode(4);
        tailA.next.next.next.next = tailB.next.next.next.next.next = new ListNode(5);

        tailA.next.next.next.next.next = tailB.next.next.next.next.next.next = new ListNode(null);

        System.out.println(getIntersectionNode1(headA, headB).val);
        System.out.println(getIntersectionNode2(headA, headB).val);
    }
}