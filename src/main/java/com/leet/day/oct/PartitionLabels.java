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

        if (StringUtils.isEmpty(S)) {
            return new ArrayList<>();
        }

        int begin = 0;
        int end = S.lastIndexOf(S.charAt(0));
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            int i1 = S.lastIndexOf(S.charAt(i));
            int i2 = S.indexOf(S.charAt(i));
            if (i1 > end && i2 > end) {
                ans.add(end - begin);
                begin = i1;
                end = i2;
            } else {
                begin = Math.min(begin, i1);
                end = Math.max(end, i2);
            }
            i = i2;
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> integers = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(integers);

    }

}
