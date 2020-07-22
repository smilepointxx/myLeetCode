package com.leet.middle.tree;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 13:00
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedBlockingDeque<>();
        deque.add(root);
        boolean t = true;
        List<List<Integer>> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (t) {
                    node = deque.pollFirst();
                } else {
                    node = deque.pollLast();
                }
                list.add(node.val);
                if (node.left != null) {
                    if (t) {
                        deque.addLast(node.left);
                    } else {
                        deque.addFirst(node.left);
                    }
                }
                if (node.right != null) {
                    if (t) {
                        deque.addLast(node.left);
                    } else {
                        deque.addFirst(node.left);
                    }
                }
            }
            t = !t;
            ans.add(list);
        }
        return ans;
    }

}
