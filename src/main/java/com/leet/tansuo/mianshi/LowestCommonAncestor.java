package com.leet.tansuo.mianshi;

import com.leet.utils.TreeNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/21 14:24
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }

        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.left, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

}
