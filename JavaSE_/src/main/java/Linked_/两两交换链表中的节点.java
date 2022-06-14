package Linked_;

/**
 * @ClassName 两两交换链表中的节点
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 13:56
 * @Version 1.0
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode tmp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = tmp;
            //移动指针
            prev=head;
            head=head.next;
        }
        return dummy.next;
    }
}
