package com.leet.middle.tree;

import com.leet.utils.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 13:00
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        boolean t = false;
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (t) {
                    stack.add(poll.val);
                } else {
                    list.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            t = !t;
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(node1));

    }

}
