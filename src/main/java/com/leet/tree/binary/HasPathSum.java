package com.leet.tree.binary;

import com.leet.utils.TreeNode;

/**
 * mac os
 * Created by smile on 2020-07-09.
 */
public class HasPathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return check(root, sum, 0);
    }

    private boolean check(TreeNode root, int sum, int S) {
        if (root == null) {
            return S == sum;
        } else {
            return check(root.left, sum, S + root.val) || check(root.right, sum, S + root.val);
        }
    }


    public static void main(String[] args) {
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

        HasPathSum sum = new HasPathSum();
        System.out.println(sum.hasPathSum(treeNode1, 22));
    }

}
