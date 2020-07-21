package com.leet.primary.list;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-16.
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for (int i = 0; i <= n; i ++) {
            p2 = p2.next;
        }

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummy.next;

    }

}
