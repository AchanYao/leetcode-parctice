package leetcode.ds;

/**
 * @author Achan
 * @date 2020/9/29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildList(int... array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head;
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        ListNode t = head;
        while (head != null) {
            builder.append(head.val).append("->");
            head = head.next;
            if (head != null && t.val == head.val) {
                // 循环链表
                builder.append(t.val);
                break;
            }
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
