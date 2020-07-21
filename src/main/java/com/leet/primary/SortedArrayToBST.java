package com.leet.primary;

import com.leet.utils.TreeNode;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/20 13:01
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = (nums.length + 1) / 2 - 1;
        TreeNode root = new TreeNode(nums[mid]);
        helper(Arrays.copyOf(nums, mid), Arrays.copyOfRange(nums, mid + 1, nums.length), root);
        return root;
    }

    private void helper(int[] left, int[] right, TreeNode root) {

        if (left != null && left.length > 0) {
            root.left = new TreeNode(left[left.length / 2]);
            helper(Arrays.copyOfRange(left, 0, left.length / 2),
                    left.length / 2 + 1 >= left.length ? null : Arrays.copyOfRange(left, left.length / 2 + 1, left.length), root.left);
        }

        if (right != null && right.length > 0) {
            root.right = new TreeNode(right[right.length / 2]);
            helper(Arrays.copyOfRange(right, 0, right.length / 2),
                    right.length / 2 + 1 >= right.length ? null : Arrays.copyOfRange(right, right.length / 2 + 1, right.length), root.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9, 10, 17, 18,19,20,21,22,23,24,25};
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(nums);
        print(root);
    }

    private static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "  ");
                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            System.out.println();
        }

    }

}
