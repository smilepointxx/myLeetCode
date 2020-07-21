package com.leet.primary.list;

import com.leet.utils.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-07-17.
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while(head != null) {
            stack.add(head.val);
            queue.offer(head.val);
            head = head.next;
        }

        while(!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-129);
        ListNode listNode2 = new ListNode(-129);
        listNode1.next = listNode2;
        System.out.println(new IsPalindrome().isPalindrome(listNode1));
    }

}
