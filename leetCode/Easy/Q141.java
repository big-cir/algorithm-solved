/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode s1 = head, s2 = head.next;
        while (s1 != null && s2 != null && s2.next != null) {
            if (s1 == s2) return true;

            s1 = s1.next;
            s2 = s2.next.next;
        }

        return false;
    }
}
