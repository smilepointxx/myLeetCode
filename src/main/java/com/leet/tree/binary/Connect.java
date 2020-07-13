package com.leet.tree.binary;

import com.leet.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * mac os
 * Created by smile on 2020-07-09.
 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node poll = queue.poll();
            addQueue(queue, poll);
            for (int i = 0; i < size - 1; i++) {
                Node next = queue.poll();
                poll.next = next;
                poll = next;
                addQueue(queue, next);
            }
            poll.next = null;
        }
        return root;
    }

    private void addQueue(Queue<Node> queue, Node node) {
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }

}
