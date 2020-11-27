package com.leet.day.nov;

import com.leet.utils.ListNode;
import com.sun.xml.internal.ws.api.message.Header;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 16:02
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode cuu = head.next;

        while (cuu != null) {
            helper(head, cuu);
        }

        return null;
    }

    private void helper(ListNode head, ListNode cuu) {

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        while (newHead.next != null); {
            if (newHead.next.val > cuu.val) {
//                newHead.next
            }
        }

    }

}
