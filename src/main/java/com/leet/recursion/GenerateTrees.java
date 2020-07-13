package com.leet.recursion;

import com.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        helper(1, n);
        return null;
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = helper(start, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode current = new TreeNode(i);
                    current.left = l;
                    current.right = r;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        GenerateTrees trees = new GenerateTrees();
        trees.generateTrees(3);
    }

}
