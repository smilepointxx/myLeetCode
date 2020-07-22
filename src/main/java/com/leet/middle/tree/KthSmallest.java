package com.leet.middle.tree;

import com.leet.utils.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 13:30
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        if (k <= 0 || root == null) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        helper(queue, root, k);
        return queue.poll();
    }

    public void helper(Queue<Integer> queue, TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (queue.size() < k) {
            queue.add(root.val);
        } else if (queue.size() == k && queue.peek() > root.val) {
            queue.poll();
            queue.add(root.val);
        }
        helper(queue, root.left, k);
        helper(queue, root.right, k);
    }

    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<Integer>(4, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 > o2 ? 1 : 0;
//            }
//        });

        for (int i = 10; i > 0; i--) {
//            if (queue.size() < 4) {
//                queue.add(i);
//            }
//            if (queue.size() >= 4 && i < queue.peek()) {
//                queue.poll();
//                queue.add(i);
//            }
//            queue.add(i);
        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(new KthSmallest().kthSmallest(node1, 2));


    }

}
