package Linked_;

/**
 * @ClassName 移除链表元素
 * @Description
 * @Author Four5prings
 * @Date 2022/5/1 12:12
 * @Version 1.0
 */
//删除链表中等于给定值 val 的所有节点示例 1：
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
public class 移除链表元素 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //设置虚拟节点 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
