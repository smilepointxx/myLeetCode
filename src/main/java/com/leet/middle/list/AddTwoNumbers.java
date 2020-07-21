package com.leet.middle.list;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-21.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;

        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            node.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            node.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
