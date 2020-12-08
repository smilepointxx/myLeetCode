package com.leet.day.dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/7 11:41
 * <p>
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] array = new int[26];
        for (char c : tasks) {
            array[c - 'A']++;
        }
        int ans = 0;
        Arrays.sort(array);
        while (array[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (array[25] == 0) {
                    break;
                }
                if (i < 26 && array[25 - i] > 0) {
                    array[25 - i]--;
                }
                ans++;
                i++;
            }
            Arrays.sort(array);
        }
        return ans;
    }


    public int leastIntervalV2(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] array = new int[26];
        for (char c : tasks) {
            array[c - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : array) {
            if (j > 0) {
                queue.offer(j);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {

                if (i < 26 && queue.peek() > 0) {
                    list.add(queue.poll() - 1);
                }
                ans++;
                if (queue.isEmpty() || list.isEmpty()) {
                    break;
                }
                i++;
            }

            for (int l : list) {
                if (l > 0) {
                    queue.offer(l);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        char[] array = new char[]{'A','A','A','B','B','B'};
        System.out.println(leastInterval.leastIntervalV2(array, 2));
    }

}
