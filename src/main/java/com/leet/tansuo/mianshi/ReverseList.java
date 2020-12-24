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
        return head;
    }

}
