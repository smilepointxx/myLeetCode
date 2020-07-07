package com.leet.tree.binary;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-07-07.
 */
public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();

        while (root != null || !stack.empty()) {

            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
        return ans;
    }

}
