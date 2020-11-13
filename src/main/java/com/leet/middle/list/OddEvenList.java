package com.leet.middle.list;

import com.leet.utils.ListNode;

import java.util.List;

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

    public ListNode oddEvenListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = p2;
        while (p1.next != null && p2.next != null) {
            if (p1.next.next != null) {
                p1.next = p1.next.next;
                p1 = p1.next;
            }

            if (p2.next.next != null) {
                p2.next = p2.next.next;
                p2 = p2.next;
            }
        }
        p1.next = p3;
        p2.next = null;
        return head;

    }

}
