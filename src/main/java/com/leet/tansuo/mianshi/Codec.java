package com.leet.tansuo.mianshi;


import com.leet.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
        recursion(root, buffer, 1);
        return buffer.toString().substring(0, buffer.length() - 1);
    }

    public void recursion(TreeNode node, StringBuffer buffer, int n) {

        if (node == null) {
            return;
        }
        buffer.append(n);
        buffer.append(":");
        buffer.append(node.val);
        buffer.append(",");
        recursion(node.left, buffer, 2 * n);
        recursion(node.right, buffer, 2 * n + 1);
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (String node : str) {
            if (node == null || node.length() == 0) {
                continue;
            }
            String[] n = node.split(":");
            map.put(Integer.parseInt(n[0]), Integer.parseInt(n[1]));
        }
        TreeNode root = new TreeNode(map.get(1));
        recursionBuild(root, 1, map);
        return root;

    }

    public void recursionBuild(TreeNode node, int n, Map<Integer, Integer> map) {
        if (map.get(2 * n) != null) {
            node.left = new TreeNode(map.get(2 * n));
            recursionBuild(node.left, 2 * n, map);
        }
        if (map.get(2 * n + 1) != null) {
            node.right = new TreeNode(map.get(2 * n + 1));
            recursionBuild(node.right, 2 * n + 1, map);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] str) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(11);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode3.right = treeNode6;
        treeNode3.left = treeNode5;
        treeNode6.right = treeNode9;

        Codec codec = new Codec();
        String ans = codec.serialize(treeNode1);
        System.out.println(ans);

        TreeNode node = codec.deserialize(ans);
        System.out.println(node.val);

        recursionV2(treeNode1);
        System.out.println();
        recursionV2(node);
    }


    public static void recursionV2(TreeNode node) {
        if (node == null) {
            return;
        }
        recursionV2(node.left);
        System.out.print(node.val);
        System.out.print(",");
        recursionV2(node.right);
    }
}


