package com.leet.primary.tree;

import com.leet.utils.TreeNode;

/**
 * mac os
 * Created by smile on 2020-07-17.
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    public boolean helper(TreeNode treeNode, Integer low, Integer up) {
        if (treeNode == null) {
            return true;
        }

        int val = treeNode.val;
        if (low != null && val <= low) {
            return false;
        }

        if (up != null && val >= up) {
            return false;
        }

        if (!helper(treeNode.left, low, val)) {
            return false;
        }

        if (!helper(treeNode.right, val, up)) {
            return false;
        }
        return true;
    }


}
