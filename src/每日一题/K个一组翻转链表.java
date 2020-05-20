package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 14:55
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        K个一组翻转链表 s = new K个一组翻转链表();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(s.reverseKGroup(listNode1, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int m = k;
        ListNode listNode1 = head;
        while (listNode1 != null && m != 0) {
            listNode1 = listNode1.next;
            m--;
        }
        if (m == 0) {
            listNode1 = reverseKGroup(listNode1, k);
            while (m != k) {
                ListNode next = head.next;
                head.next = listNode1;
                listNode1 = head;
                head = next;
                m++;
            }
            head = listNode1;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
