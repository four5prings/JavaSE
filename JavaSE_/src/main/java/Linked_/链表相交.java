package Linked_;

/**
 * @ClassName 链表相交
 * @Description
 * @Author Four5prings
 * @Date 2022/5/2 14:36
 * @Version 1.0
 */
//给你两个单链表的头节点 headA 和 headB ，
// 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class 链表相交 {
    /**
     *
     * @param headA
     * @param headB
     * @return 链表相交 因为链表的指针存在， 如果有两个链表，其中的某一个节点的指针相同，
     *          那么往后就必定相同所以要比较是否相交，先保证链表的长度一致，
     *          即长链表先移动两链表长度之差的前一个节点，然后判断他们的.next(指针)是否相同
     *          相同则相交，不同则同时向后移动
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //得到两个链表的长度
        int Asize = getSize(headA);
        int Bsize = getSize(headB);
        int moveSize = 0;
        //声明相同的起始节点
        ListNode sameNode = null;
        //声明虚拟节点
        ListNode tmpA = new ListNode(-1);
        tmpA.next = headA;
        ListNode tmpB = new ListNode(-1);
        tmpB.next = headB;

        //判断A B链表长度大小 ，大的先移动至与小链表剩余相同长度
        if (Asize > Bsize) {
            moveSize = Asize - Bsize;
            while (moveSize-- > 0) {
                tmpA = tmpA.next;
            }
            while (tmpB != null) {
                if (tmpA.next == tmpB.next) {
                    return sameNode = tmpA.next;
                }
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
        } else {
            moveSize = Bsize - Asize;
            while (moveSize-- > 0) {
                tmpB = tmpB.next;
            }
            while (tmpA != null) {
                if (tmpA.next == tmpB.next) {
                    return sameNode = tmpA.next;
                }
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
        }
        return sameNode;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     *
     * @param headA
     * @param headB
     * @return 另一种写法
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         * 计算出两个链表的长度
         */
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;

        /**
         * 以下操作旨在将较长的链表命名为curA，长度命名为lenA
         * 省去了判断A B链表的长度差 因为都是名字指代，并不是headA和headB自身进行判断
         */
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        /**
         * 开始移动较长的链表，使两条链表末尾长度相同
         */
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
