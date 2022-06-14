package Review.Array_Linked;

/**
 * @ClassName swapPairs
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 21:26
 * @Version 1.0
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //创建虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null && cur.next != null) {
            tmp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
