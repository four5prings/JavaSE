package Linked_;

/**
 * @ClassName 反转链表
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 13:23
 * @Version 1.0
 */

/**
 * 使用双指针 一个虚拟节点 一个临时节点 一个用来位移指向链表中的节点
 *
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
