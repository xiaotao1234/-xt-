package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 8:13
 */
public class 合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        if (p1 == null) cur.next = p2;
        if (p2 == null) cur.next = p1;
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists1(ListNode[] lists) {//优先队列
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge2(lists, 0, lists.length - 1);
    }

    private ListNode merge2(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge2(lists, left, mid);
        ListNode l2 = merge2(lists, mid + 1, right);
        return mergeTwoLists2(l1, l2);
    }

    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return MergeTwoLists(lists, 0, lists.length - 1);
    }

    public ListNode MergeTwoLists(ListNode[] listNodes, int left, int right) {
        if (left == right) {
            return listNodes[left];
        }
        int middle = left + (right - left) / 2;
        ListNode listNode1 = MergeTwoLists(listNodes, left, middle);
        ListNode listNode2 = MergeTwoLists(listNodes, middle + 1, right);
        return merge3(listNode1, listNode2);
    }

    public ListNode merge3(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        if (leftNode.val < rightNode.val) {
            leftNode.next = merge3(leftNode.next, rightNode);
            return leftNode;
        } else {
            rightNode.next = merge3(rightNode.next, leftNode);
            return rightNode;
        }
    }

//    作者：powcai
//    链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
