package com.leet.tree.binary;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * mac os
 * Created by smile on 2020-07-08.
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> lineAns = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                lineAns.add(poll.val);
                if (poll.left != null) {

                    queue.offer(poll.left);
                }
                if (poll.right != null) {

                    queue.offer(poll.right);
                }
            }
            ans.add(lineAns);
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(treeNode1));
    }

}
