package com.leet.day.jan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/11 19:39
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                j++;
            }
            if (j == i + 1) {
                ans.add(nums[i] + "");
            } else {
                ans.add(nums[i] + "->" + nums[j - 1]);
            }
            i = j;
        }
        return ans;
    }

}
