package 二刷冲冲冲.链表;

/**
 * @author xt
 * @version 1.0
 * @date 2020/7/15 11:09
 */
public class 链表反转 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
