package com.leet.day.oct;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/27 11:51
 */
public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        help(root, ans);
        return ans;
    }

    private void help(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }
        help(root.left, ans);
        ans.add(root.val);
        help(root.right, ans);
    }


}
