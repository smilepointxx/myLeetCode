package com.leet.hight.list;

import com.leet.utils.ListNode;

import java.util.PriorityQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 15:12
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(queue.poll());
        ListNode node = newHead;
        while (!queue.isEmpty()) {
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return newHead;
    }

}
