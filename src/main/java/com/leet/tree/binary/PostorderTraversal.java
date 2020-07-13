package com.leet.tree.binary;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-07-08.
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                TreeNode peek = stack.peek();
                if (peek.right != null) {
                    root = peek.right;
                } else {
                    TreeNode pop = stack.pop();
                    ans.add(pop.val);
                    pop = null;
                }
            }
        }
        return ans;

    }

    public List<Integer> postorderTraversalV2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        recurrence(root);
        return cAns;

    }


    public List<Integer> cAns = new ArrayList<Integer>();

    public void recurrence(TreeNode node) {
        if (node == null) {
            return;
        }
        recurrence(node.left);
        recurrence(node.right);
        cAns.add(node.val);
    }

    public static void main(String[] args) {

    }

}
