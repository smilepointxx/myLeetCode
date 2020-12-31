package com.leet.day.oct;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/16 16:16
 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedBlockingQueue<Node>();
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = null;
            Node last = null;
            for (int i = 0; i < size; i++) {
                Node dequeue = queue.poll();
                System.out.println(dequeue.val);
                last = dequeue;
                if (current == null) {
                    current = dequeue;
                } else {
                    current.next = dequeue;
                    current = dequeue;
                }
                if (dequeue.left != null) {
                    queue.offer(dequeue.left);
                    queue.offer(dequeue.right);
                }
            }
            last.next = null;
            size = 2 * size;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.left = node2;
        Node node3 = new Node(3);
        node1.right = node3;
        Node node4 = new Node(4);
        node2.left = node4;
        Node node5 = new Node(5);
        node2.right = node5;
        Node node6 = new Node(6);
        node3.left = node6;
        Node node7 = new Node(7);
        node3.right = node7;

        Connect connect = new Connect();
        connect.connect(node1);


    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}



