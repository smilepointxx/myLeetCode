package com.leet.hight.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 15:30
 */
public class CopyRandomList {

    public static Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (visited.get(head) != null) {
            return visited.get(head);
        }

        Node node = new Node(head.val);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
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
