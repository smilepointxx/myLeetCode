package com.leet.stackandqueue.code;

/**
 * mac os
 * Created by smile on 2020-07-07.
 */
public class FindTargetSumWays {

    public int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        calculate(nums, 0, S, 0);
        return ans;
    }

    public void calculate(int[] nums, int index, int S, int sum) {
        if (index == nums.length) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        calculate(nums, index + 1, S, sum + nums[index]);
        calculate(nums, index + 1, S, sum - nums[index]);
    }


    public static void main(String[] args) {
        FindTargetSumWays sumWays = new FindTargetSumWays();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(sumWays.findTargetSumWays(nums, 3));

    }


    public int findTargetSumWaysV2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }


        return 1;
    }

}
