package com.leet.primary.list;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-16.
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null) {
            count++;
            p2 = p2.next;
            if (count >= n) {
                p1 = p1.next;
            }
        }
        return null;
    }

}
