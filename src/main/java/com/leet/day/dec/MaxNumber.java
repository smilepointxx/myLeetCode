package com.leet.day.dec;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/2 11:14
 */
public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int p1 = 0;
        int p2 = 0;
        int[] ans = new int[k];
        int index = 0;
        while (k > 0) {
            int[] middle = help(nums1, nums2, k - 1, p1, p2);

            if (middle[1] == 1) {
                ans[index++] = nums2[middle[0]];
                p2 = middle[0] + 1;
            } else {
                ans[index++] = nums1[middle[0]];
                p1 = middle[0] + 1;
            }
            k--;
        }
        return ans;
    }

    public int[] help(int[] nums1, int[] nums2, int k, int p1, int p2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int m = nums1.length - p1;  //剩余个数
        int n = nums2.length - p2;  //剩余个数
        int[] ans = new int[3];
        int maxIndex1;
        int maxIndex2;
        if (k > m && k > n) {
            maxIndex1 = searchMax(nums1, p1, length1 - (k - n));
            maxIndex2 = searchMax(nums2, p2, length2 - (k - m));

        } else if (k > m && k < n) {
            maxIndex1 = searchMax(nums1, p1, length1);
            maxIndex2 = searchMax(nums2, p2, length2 - (k - m));
        } else if (k < m && k > n) {
            maxIndex1 = searchMax(nums1, p1, length1 - (k - n));
            maxIndex2 = searchMax(nums2, p2, length2);
        } else {
            maxIndex1 = searchMax(nums1, p1, length1);
            maxIndex2 = searchMax(nums2, p2, length2);
        }

        if (p1 == length1) {
            ans[0] = maxIndex2;
            ans[1] = 1;
        } else if (p2 == length2) {
            ans[0] = maxIndex1;
        } else {
            if (nums1[maxIndex1] > nums2[maxIndex2]) {
                ans[0] = maxIndex1;
            } else if (nums1[maxIndex1] < nums2[maxIndex2]) {
                ans[0] = maxIndex2;
                ans[1] = 1;
            } else {
                int index = doEqual(nums1, nums2, maxIndex1 + 1, maxIndex2 + 1);
                if (index == 0) {
                    ans[0] = maxIndex1;
                } else {
                    ans[0] = maxIndex2;
                }
                ans[1] = index;
            }
        }
        return ans;

    }

    public int doEqual(int[] nums1, int[] nums2, int maxIndex1, int maxIndex2) {
        int i = maxIndex1;
        int j = maxIndex2;
        while (maxIndex1 < nums1.length && maxIndex2 < nums2.length) {
            if (nums1[maxIndex1] > nums2[maxIndex1]) {
                return 0;
            } else if (nums1[maxIndex1] < nums2[maxIndex1]) {
                return 1;
            }
            maxIndex1++;
            maxIndex2++;
        }
        if (maxIndex1 == nums1.length && maxIndex2 == nums2.length) {
            i -= 2;
            j -= 2;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    return 1;
                } else if (nums1[i] < nums2[j]){
                    return 0;
                }
                i--;
                j--;
            }
            return i == -1 ? 0 : 1;
        } else {
            return maxIndex1 == nums1.length ? 0 : 1;
        }


    }

    public int searchMax(int[] nums, int left, int right) {
        if (right == 0) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int max = nums[left];
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;

    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{8, 9};
//        int[] nums2 = new int[]{3, 9};
//        MaxNumber maxNumber = new MaxNumber();
//        int[] ints = maxNumber.maxNumber(nums1, nums2, 3);
//        for (int i : ints) {
//            System.out.println(i);
//        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                throw new RuntimeException();
            }
        });
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
    }

}
