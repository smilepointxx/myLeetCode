package com.leet.day.Set;

import com.leet.utils.TreeNode;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/9/24 12:58
 */
public class FindMode {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> storageMap = new HashMap<>();
        help(root, storageMap);
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : storageMap.entrySet()) {
            if (entry.getValue() > max) {
                ans.clear();
                ans.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;

    }

    private void help(TreeNode root, Map<Integer, Integer> storageMap) {
        if (root == null) {
            return;
        }
        storageMap.put(root.val, storageMap.getOrDefault(root.val, 0) + 1);
        help(root.left, storageMap);
        help(root.right, storageMap);
    }
}
