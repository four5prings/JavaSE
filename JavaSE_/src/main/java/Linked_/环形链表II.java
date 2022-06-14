package Linked_;

/**
 * @ClassName 环形链表II
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 15:53
 * @Version 1.0
 */
//题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。
//说明：不允许修改给定的链表。
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode circleStart = null;
        //定义虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //定义快慢指针，用来判断是否有环
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.next == slow.next) {
                ListNode index1 = fast.next;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return circleStart = index1;
            }
        }
        return circleStart;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * 判断是否有环存在
             */
            if (fast == slow) {
                //声明两个节点，分别从开始和快慢指针相遇的地方开始走，
                // 此时他们相遇的节点就是环入口
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
