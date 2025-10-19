/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode pointer = answer;
    
        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                pointer.next = list2;
                list2 = list2.next;
            } else if (list2 == null && list1 != null) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                int v1 = list1.val;
                int v2 = list2.val;

                if (v2 <= v1) {
                    pointer.next = list2;
                    list2 = list2.next;
                } else {
                    pointer.next = list1;
                    list1 = list1.next;
                }
            }

            pointer = pointer.next;
        }

        return answer.next;
    }
}
