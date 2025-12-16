// 1-Pass Slow/Fast Pointer: O(N/2) = O(N)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;
        }

        return slow;       
    }
}

// O(N) + O(N/2) = O(N)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = head;
        if (head == null) return head;
        int size = (getSize(dummy) / 2);
        while (size != 0) {
            size--;
            head = head.next;
        }

        return head;
    }

    public int getSize(ListNode dummy) {
        int size = 0;
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }

        return size;
    }
}
