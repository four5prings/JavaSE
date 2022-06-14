package Linked_;

/**
 * @ClassName MyLinkedList
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 12:53
 * @Version 1.0
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class MyLinkedList {
    int size;
    ListNode head;

    //初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode dummy = head;
        for (int i = 0; i <= index; i++) {
            dummy = dummy.next;
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = dummy.next;
        dummy.next = toAdd;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        size--;
    }
}
