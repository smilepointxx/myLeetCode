package com.leet.tansuo.mianshi;

import com.leet.utils.ListNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/22 17:48
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode before = newHead;
        while (head != null) {
            if (head.val == val) {
                before.next = head.next;
                break;
            } else {
                before = head;
                head = head.next;
            }
        }
        return newHead.next;
    }

}
