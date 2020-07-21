package 二刷冲冲冲.链表;

/**
 * @author xt
 * @version 1.0
 * @date 2020/7/15 10:32
 */
public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (n != k && cur.next != null) {
            n++;
            cur = cur.next;
        }
        if (n == k) {
            cur = reverseKGroup(cur, k);
            while (n > 0) {
                n--;
                ListNode listNode = head.next;
                head.next = cur;
                cur = head;
                head = listNode;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (n != k && cur.next != null) {
            n++;
            cur = cur.next;
        }
        if (n == k) {
            cur = reverseKGroup1(cur, k);
            while (n >= 0) {
                n--;
                ListNode listNode = head.next;
                head.next = cur;
                cur = head;
                head = listNode;
            }
            head = cur;
        }
        return head;
    }
//
//    public ListNode get(ListNode head, int k) {
//        if (head == null) return null;
//        ListNode listNode = get(head.next, k);
//
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
