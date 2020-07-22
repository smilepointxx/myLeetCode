package com.leet.middle.list;

import com.leet.utils.ListNode;

import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-21.
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode listNodeA1  = new ListNode(4);
        ListNode listNodeA2  = new ListNode(1);
        listNodeA1.next = listNodeA2;

        ListNode listNodeB1  = new ListNode(5);
        ListNode listNodeB2  = new ListNode(0);
        listNodeB1.next = listNodeB2;
        ListNode listNodeB3  = new ListNode(1);
        listNodeB2.next = listNodeB3;

        ListNode listNodeC1  = new ListNode(8);
        ListNode listNodeC2  = new ListNode(4);
        ListNode listNodeC3  = new ListNode(5);
        listNodeC1.next = listNodeC2;
        listNodeC2.next = listNodeC3;


        listNodeA2.next = listNodeC1;
        listNodeB3.next = listNodeC1;


        System.out.println(new GetIntersectionNode().getIntersectionNode(listNodeA1, listNodeB1).val);



    }


}
