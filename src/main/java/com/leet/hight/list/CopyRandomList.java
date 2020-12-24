package com.leet.hight.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 15:30
 */
public class CopyRandomList {

    public static Map<Integer, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node newHead = new Node(-1);
        Node en = newHead;
        Node node = head;


        while (node.next != null) {
            if (node.random == null) {
                Node n = new Node(node.val);
                en.next = n;
            } else if (map.get(node.hashCode()) != null) {
                en.next = map.get(node.hashCode());
            } else{
                en.next = helper(node);
            }
            en = en.next;
            node = node.next;
        }

        return newHead.next;
    }

    private Node helper(Node node) {
        if (map.get(node.hashCode()) != null) {
            return map.get(node.hashCode());
        }
        Node n = new Node(node.val);
        n.next = node.next;
        return null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
