package Review.Array_Linked;

/**
 * @ClassName reverseList
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 21:13
 * @Version 1.0
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //创建虚拟节点
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp ;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
