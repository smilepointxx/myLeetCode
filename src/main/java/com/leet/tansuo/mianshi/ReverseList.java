package com.leet.tansuo.mianshi;

import com.leet.utils.ListNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 18:41
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode next = node;
            node = node.next;
            next.next = head;
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        reverseListV2(listNode1);
    }


}
