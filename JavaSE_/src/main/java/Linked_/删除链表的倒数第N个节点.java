package Linked_;

/**
 * @ClassName 删除链表的倒数第N个节点
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 14:15
 * @Version 1.0
 */
public class 删除链表的倒数第N个节点 {
    /**
     *
     * @param head
     * @param n
     * @return 本题的重点一个是快慢指针 另一个是如何处理倒数第n个数。
     *      倒数第n个数，因为链表没有明确的size 而且单向链表只能从头遍历到尾，不能反向遍历
     *      所以先让快指针走n次，（快指针仅用来处理倒数问题）此时慢指针不动。此时两个指针一起移动，
     *      他们之间的距离始终保持在n，当快指针移动到末尾时，那么慢指针也就移动到了倒数第n个数
     *      此时判断边界条件，让slow 的上一个 节点内的next属性指向slow节点的下一个节点即完成删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头节点
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode prev  = null;
        while (fast != null) {
            prev  = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev .next = slow.next;
        return dummy.next;
    }
}
