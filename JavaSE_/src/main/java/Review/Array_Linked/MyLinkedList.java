package Review.Array_Linked;

/**
 * @ClassName MyLinkedList
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 20:33
 * @Version 1.0
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur =head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。
    // 插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。
    // 如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，
    // 则不会插入节点。如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode insert = new ListNode(val);
        insert.next = pre.next;
        pre.next = insert;

    }

    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
