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

    List<List<Integer>> list;
    boolean ans = true;
    int[] vis;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        vis = new int[numCourses];
        for (int[] i : prerequisites) {
            list.get(i[1]).add(i[0]);
        }
        for (int i = 0; i < numCourses && ans; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        return ans;

    }

    public void dfs(int i) {

        vis[i] = 1;
        for (int j : list.get(i)) {
            if (vis[j] == 0) {
                dfs(j);
                if (!ans) {
                    return;
                }
            } else if (vis[j] == 1) {
                ans = false;
                return;
            }
        }
        vis[i] = 3;

    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        int[][] prerequisites = new int[][]{
                {1,0}
        };

        System.out.println(canFinish.canFinish(2, prerequisites));
    }

}
