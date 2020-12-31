package com.leet.tansuo.mianshi;

import com.leet.utils.ListNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/31 14:45
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        k = k % size;
        node.next = head;
        int i = 0;
        while (i < k) {
            head = head.next;
            i++;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;


    }

}
