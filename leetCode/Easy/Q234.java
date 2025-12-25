// 공간복잡도: O(1), 시간복잡도: O(N)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}

// 공간복잡도: O(N), 시간복잡도: O(N)
class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
