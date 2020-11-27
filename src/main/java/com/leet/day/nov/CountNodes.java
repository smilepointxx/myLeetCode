package com.leet.day.nov;

import com.leet.utils.TreeNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 14:28
 */
public class CountNodes {

    int ans = 0;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        ans = ans + 1;
        helper(root.left);
        helper(root.right);
    }

}
