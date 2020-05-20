package 链表;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/18 21:22
 */
public class 环路检测 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        while (listNode1 != null && listNode2 != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
            if (listNode1 == listNode2) {
                listNode1 = head;
                while (listNode1 != listNode2) {
                    listNode1 = listNode1.next;
                    listNode2 = listNode2.next;
                }
                return listNode1;
            }
        }
        return null;
    }

    
}
