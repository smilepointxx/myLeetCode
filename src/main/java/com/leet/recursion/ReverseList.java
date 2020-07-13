package com.leet.recursion;

import com.leet.utils.ListNode;

/**
 * mac os
 * Created by smile on 2020-07-11.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode cursor = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = cursor;
            cursor = head;
            head = next;
        }
        return head;
    }


    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ReverseList reverseList = new ReverseList();
        reverseList.reverseListV2(listNode1);
    }

}
