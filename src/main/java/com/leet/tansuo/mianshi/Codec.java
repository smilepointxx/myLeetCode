package com.leet.tansuo.mianshi;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/23 14:22
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        buffer.append(root.val);
        buffer.append(",");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
//                poll
            }
        }
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


