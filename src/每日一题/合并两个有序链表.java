package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/1 22:21
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode pre = new ListNode(0);
        ListNode listNode = pre;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
                pre.next.next = null;
                pre = pre.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
                pre.next.next = null;
                pre = pre.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        } else if (l2 != null) {
            pre.next = l2;
        }
        return listNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
