package Review.Array_Linked;

/**
 * @ClassName removeElements
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 20:22
 * @Version 1.0
 */
public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //创建虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
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
