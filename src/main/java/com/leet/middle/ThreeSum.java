package com.leet.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/20 20:15
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }

        fastSort(nums, 0, nums.length - 1);

        for (int p1 = 0; p1 < nums.length - 2; p1++) {
            if(nums[p1] > 0) {
                break;
            }
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                continue;
            }
            int p3 = nums.length - 1;
            int p2 = p1 + 1;
            while(p2 < p3) {
                if ( p2 > (p1 + 1) && nums[p2] == nums[p2-1]) {
                    p2++;
                    continue;
                }

                if (p3 < (nums.length - 1) && nums[p3] == nums[p3 + 1]) {
                    p3--;
                    continue;
                }

                int c = check(nums[p1], nums[p2], nums[p3]);
                if (c == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    list.add(nums[p3]);
                    ans.add(list);
                    p2++;
                    p3--;
                } else if (c < 0){
                    p2++;
                } else {
                    p3--;
                }
            }
        }

        return ans;
    }

    private int check(int num, int num1, int num2) {
        return num + num1 + num2;

    }


    private void fastSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        while (left != right) {
            while (left < right && nums[right] > nums[l]) {
                right--;
            }

            while (left < right && nums[left] <= nums[l]) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, l, left);
        fastSort(nums, left + 1, r);
        fastSort(nums, l, left - 1);
    }

    private void swap(int[] nums, int left, int right) {
        int index = nums[left];
        nums[left] = nums[right];
        nums[right] = index;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
//        int[] nums = new int[]{4, 5, 3, 2, 6};
        long begin = System.currentTimeMillis();
        System.out.println(new ThreeSum().threeSum(nums));
        System.out.println(System.currentTimeMillis() - begin);
//        new ThreeSum().fastSort(nums, 0, nums.length - 1);
//        for (int num : nums) {
//            System.out.println(num);
//        }


    }

}
