package com.leet.day.Set;

import com.leet.utils.TreeNode;

/**
 * @Author: xingxing.chang
 * @Date: 2020/9/24 21:12
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        help(t1, t2, null);
        return t1;
    }

    private void help(TreeNode t1, TreeNode t2, TreeNode parent) {


    }

}
