package com.leet.hight.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/8 17:54
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

 *[[1,0],[0,2],[2,1]]
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        for (int[] i : prerequisites) {
            List<Integer> orDefault1 = map1.getOrDefault(i[0], new ArrayList<>());
            orDefault1.add(i[1]);
            map1.put(i[0], orDefault1);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map1.entrySet()) {
            for (int i : entry.getValue()) {
                if (map1.get(i) != null && map1.get(i).contains(entry.getKey())) {
                    return false;
                }
            }
        }
        return true;

    }

}
