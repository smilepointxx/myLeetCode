package com.leet.day.oct;

import com.leet.utils.ListNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/26 18:49
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = helpRevertNode(slow.next);
        slow.next =null;

    }

    private ListNode helpRevertNode(ListNode node) {
        if (node == null) {
            return node;
        }
        node.next = helpRevertNode(node.next);
        return node;



    }

}
