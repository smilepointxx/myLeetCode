package com.leet.tree.binary;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * mac os
 * Created by smile on 2020-07-08.
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        int ans = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            ans ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return ans;



    }


    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode rootCopy = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(rootCopy);
        while(!queue.isEmpty()) {
            root = queue.poll();
            rootCopy = queue.poll();

            if (root == null && rootCopy == null) {
                continue;
            }

            if (root == null || rootCopy == null || (root.val != rootCopy.val)) {
                return false;
            }


            queue.offer(root.left);
            queue.offer(rootCopy.right);


            queue.offer(root.right);
            queue.offer(rootCopy.left);

        }
        return true;
    }

}
