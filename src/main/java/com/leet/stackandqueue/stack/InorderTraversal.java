package com.leet.stackandqueue.stack;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-06-29.
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        getAns(root, ans);
        return ans;
    }

    private void getAns(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        getAns(root.left, ans);
        ans.add(root.val);
        getAns(root.right, ans);
    }


    public List<Integer> inorderTraversalV2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }



}
