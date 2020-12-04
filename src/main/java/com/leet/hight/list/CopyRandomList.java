package com.leet.hight.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 15:30
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Node ans = new Node(-1);
        Node n = ans;
        while (head.next != null) {
            Node node = map.get(head.hashCode());
            if (node != null) {

            }
            Node random = head.random;
            while(random != null) {

            }
            node = new Node(head.val);


            head = head.next;
        }

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
