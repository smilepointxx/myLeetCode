package com.leet.day.oct;

import com.leet.utils.ListNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/27 14:07
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p1 = newHead;
        ListNode p2 = newHead;
        int count = 0;
        while (p2.next != null) {
            if (count < n) {
                p2 = p2.next;
                count ++;
                continue;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return newHead.next;
    }

}
