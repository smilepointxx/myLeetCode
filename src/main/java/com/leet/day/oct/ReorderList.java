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
        ListNode left = head;
        while (left != null && right != null) {
            ListNode leftNext = left.next;
            left.next = right;
            right = right.next;
            left.next.next = leftNext;
            left = left.next.next;
        }

    }

    private ListNode helpRevertNode(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode next = helpRevertNode(node.next);
        next.next = node;
        node.next = null;
        return next.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ReorderList reorderList = new ReorderList();
        ListNode node = reorderList.helpRevertNode(node1);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }



}
