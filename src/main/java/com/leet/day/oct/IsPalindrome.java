package com.leet.day.oct;

import com.leet.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/23 18:53
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        List<Integer> array = new ArrayList<>();
        while (fast.next != null && fast.next.next != null) {
            array.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        array.add(slow.val);
        int size = fast.next != null ? array.size() : array.size() - 1;
        for (int i = size - 1; i >= 0; i--) {
            slow = slow.next;
            if (slow == null) {
                return false;
            }
            if (!array.get(i).equals(slow.val)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        ListNode nod3 = new ListNode(3);
        node2.next = nod3;
//        ListNode nod4 = new ListNode(2);
//        nod3.next = nod4;
//        ListNode nod5 = new ListNode(1);
//        nod4.next = nod5;
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome(node);
        System.out.println(palindrome);

    }

}
