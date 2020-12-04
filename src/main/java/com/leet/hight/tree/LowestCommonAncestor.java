package com.leet.hight.tree;

import com.leet.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 17:05
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int value = poll.val;
                if (value == p.val) {

                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return null;
    }

}
