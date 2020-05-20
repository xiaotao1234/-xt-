package 链表;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/13 9:11
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        //先每隔k个进行递归（实际上是向底部逐渐推进的过程），
        // 然后在递归到底部时（当前到尾部的所有结点的数量小于k时，代表不够k，不用翻转，
        // 若进行了翻转，返回值为翻转后的头部节点（未翻转时间他在尾部），
        // 若未进行翻转，返回值为头部节点
        // 翻转操作可以采用外开递归或者迭代方式进行
        // 这里使用了迭代来进行
        // 三个关键指针：cur ，listnode1，head
        // 初始阶段（while循环体未执行时的初始状态） head -> listnode1 -> n -> n -> n     cur -> n -> n -> n
        // while循环执行一次后 ：
        // cur -> n -> n -> n                => head1 -> cur1 -> n -> n -> n
        // head -> listnode1 -> n -> n -> n  => listnode1 -> n -> n -> n
        // 递归返回的本段后的翻转链表的头指针要接在本段翻转后的尾节点后
        // 然后依靠3个指针来逐步将当前段添加到后段的头部即： 1，2，3，4   8，7，6，5  =>  2,3,4   1,8,7,6,5  => 3,4   2,1,8,7,6,5  => 4  3,2,1,8,7,6,5 =>  4,3,2,1,8,7,6,5）
        ListNode cur = head;
        int m = 0;
        while (cur != null && m != k) {
            cur = cur.next;
            m++;
        }
        if (m == k) {
            cur = reverseKGroup(cur, k);//整体递归次数应该为 listnode.size/k 次，用递归是为了循环每次以k个元素向下推进，且依靠递归的现场保存和恢复来重现，每k个节点时的执行环境（这里是拿到了每k个节点，及在递归回升上来的后续节点的尾节点）
            while (m != 0) {
                m--;
                ListNode listNode1 = head.next;
                head.next = cur;
                cur = head;
                head = listNode1;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup4(ListNode head, int k) {
        ListNode cur = head;
        int m = 0;
        while (cur != null && m != k) {
            cur = cur.next;
            k++;
        }
        if (k == m) {
            cur = reverseKGroup4(cur, k);
            while (m != 0) {
                m--;
                ListNode listNode = head.next;
                head.next = cur;
                cur = head;
                head = listNode;
            }
            head = cur;
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

    public ListNode reverseKGroup1(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode head1 = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup3(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup6(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (n != k && head != null) {
            cur = cur.next;
            n--;
        }
        if (n == k) {
            while (n != 0) {
                cur = reverseKGroup6(cur.next, k);
                ListNode listNode = head.next;
                head.next = cur;
                cur = head;
                head = listNode;
            }
            head = cur;
        }
        return head;
    }

//    作者：powcai
//    链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
