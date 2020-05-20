package 链表;

/**
 * Created by Xiao Tao on 2020/2/24 16:35
 */
public class 重排链表 {

    private ListNode headreal;
    ListNode listNode;
    private static ListNode listNsode;

    public static void main(String[] args) {
        重排链表 s = new 重排链表();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        s.reorderList1(listNode1);
        System.out.println(listNsode);
    }

    public void reorderList1(ListNode head) {
        int i = 0;
        ListNode listNode1 = new ListNode(0);
        listNode1.next = head;
        ListNode listNode = head;
        while (listNode != null) {
            listNode = listNode.next;
            i++;
        }
        if (i <= 2) {
            return;
        }
        get(listNode1.next, i);
    }

    public ListNode get(ListNode listNode, int length) {
        if (length <= 0) {
            return listNode;
        }
        ListNode listNode1 = get(listNode.next, length - 2);
        if (length == 1) {
            listNode.next = null;
            return listNode1;
        } else if (length == 2) {
            ListNode listNode2 = listNode1.next;
            listNode1.next = null;
            return listNode2;
        } else {
            ListNode listNode3 = listNode.next;
            listNode.next = listNode1;
            ListNode listNode2 = listNode1.next;
            listNode1.next = listNode3;
            return listNode2;
        }
    }

    public void reorderList(ListNode head) {
        headreal = head;
        listNsode = new ListNode(0);
        listNsode.next = head;
        get(head);
        head = listNsode.next;
    }

    public void get(ListNode head) {
        if (head == null) {
            return;
        }
        get(head.next);
        if (headreal != null) {
            if (head.val != headreal.val) {
                listNode = headreal.next;
                headreal.next = head;
                head.next = listNode;
                headreal = listNode;
            } else {
                headreal.next = null;
            }
        }
    }

    ListNode first;
    ListNode second;
    ListNode tmp;

//    public void reorderList1(ListNode head) {
//        first = head;
//        second = head.next;
//        tmp = head.next.next;
//        get1(head);
//    }

//    public void get1(ListNode head) {
//        if (head.next != null || head == null) {
//            return;
//        }
//        get1(head.next);
//        if () {
//
//            first.next = head;
//            head.next = second;
//            first = tmp;
//            second = tmp.next;
//            tmp = second.next;
//        }
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
