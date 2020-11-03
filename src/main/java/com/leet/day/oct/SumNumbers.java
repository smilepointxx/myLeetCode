package com.leet.day.oct;

import com.leet.utils.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/29 14:13
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Queue<Integer> queueNum = new LinkedBlockingQueue<>();
        queue.offer(root);
        queueNum.offer(root.val);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int value = queueNum.poll();

            if (poll == null) {
                continue;
            }
            if (poll.left == null && poll.right == null) {
                ans += value;
            } else {
                if (poll.left != null) {
                    queue.offer(poll.left);
                    queueNum.offer(value * 10 + poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    queueNum.offer(value * 10 + poll.right.val);
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        SumNumbers sumNumbers = new SumNumbers();
        int i = sumNumbers.sumNumbers(node1);
        System.out.println(i);
    }

}
