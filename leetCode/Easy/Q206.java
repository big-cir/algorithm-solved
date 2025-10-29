// sol1: recursive, 시간복잡도: O(n), 공간복잡도: O(n)
class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nh = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return nh;
    }
}

// so2: stack, 시간복잡도: O(n), 공간복잡도: O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }

        ListNode first = stack.removeFirst();
        ListNode answer = first;
        while (!stack.isEmpty()) {
            first.next = stack.removeFirst();
            first = first.next;
        }
        first.next = null;

        return answer;
    }
}
