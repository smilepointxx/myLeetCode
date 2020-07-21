package com.leet.primary.list;

import com.leet.utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * mac os
 * Created by smile on 2020-07-19.
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        map.put(head, 1);
        while (head.next != null) {
            if (map.get(head.next) != null) {
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }
        return false;

    }

    public boolean hasCycleV2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            System.out.println(p1.val + "  :  " + p2.val);
            if (p1 == p2) {
                return true;
            }

        }
        return false;
    }

}
