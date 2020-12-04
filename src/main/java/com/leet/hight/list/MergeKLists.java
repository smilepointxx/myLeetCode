package com.leet.hight.list;

import com.leet.utils.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/3 21:00
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            node.next = poll;
            node = node.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;


        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        ListNode[] list = new ListNode[]{node1, node4};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(list);
        System.out.println(listNode.val);

    }

}
