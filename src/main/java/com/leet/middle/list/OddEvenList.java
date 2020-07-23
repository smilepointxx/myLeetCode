package com.leet.middle.list;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-21.
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode p2 = head;

        ListNode p3 = head.next;
        ListNode p4 = head.next;

        while (p4 != null && p2.next != null) {
            p2.next = p4.next;
            p2 = p2.next;
            p4.next = p2.next;
            p4 = p4.next;
        }
        p2.next = p3;
        return head;

    }

}
