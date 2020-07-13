package com.leet.recursion;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-10.
 */
public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = helper(second.next);
        second.next = first;
        return second;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = swapPairs.swapPairs(listNode1);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
