package com.leet.day.oct;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/26 18:10
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        int begin = 0;
        int end = S.lastIndexOf(S.charAt(0));
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        while (i < S.length()) {
            int i1 = S.indexOf(S.charAt(i));
            int i2 = S.lastIndexOf(S.charAt(i));
            if (i1 > end && i2 > end) {
                ans.add(end - begin + 1);
                begin = i1;
                end = i2;
            } else {
                begin = Math.min(begin, i1);
                end = Math.max(end, i2);
            }
            i ++;
        }
        ans.add(end - begin + 1);
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> integers = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(integers);

    }

}
