package com.leet.day.nov;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/25 20:54
 */
public class SortString {

    public String sortString(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        Queue<Character> queue = new PriorityQueue<>(s.length(), new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return (int) o1 - (int) o2;
            }
        });
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        Deque<Character> deque = new LinkedList<>();
        while (!queue.isEmpty()) {
            deque.offer(queue.poll());
        }

        char[] ans = new char[s.length()];
        int index = 0;
        boolean up = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (up) {
                char left = deque.poll();
                ans[index++] = left;
                for (int i = 1; i < size; i++) {
                    char poll = deque.poll();
                    if (poll > left) {
                        ans[index++] = poll;
                        left = poll;
                    } else {
                        deque.offer(poll);
                    }
                }
            } else {
                char right = deque.pollLast();
                ans[index++] = right;
                for (int i = 1; i < size; i++) {
                    char poll = deque.pollLast();
                    if (poll < right) {
                        ans[index++] = poll;
                        right = poll;
                    } else {
                        deque.addFirst(poll);
                    }
                }
            }
            up = !up;
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        SortString sortString = new SortString();
        System.out.println(sortString.sortStringV2("aaaabbbbcccc"));


    }

    public String sortStringV2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] times = new int[26];
        for (char c : s.toCharArray()) {
            times[(int) c - 97] = times[(int) c - 97] + 1;
        }
        int index = 0;
        char[] ans = new char[s.length()];
        boolean up = true;
        while (index < s.length()) {
            if (up) {
                int i = 0;
                while (i < 26) {
                    if (times[i] > 0) {
                        times[i] = times[i] - 1;
                        ans[index++] = (char)(i + 97);
                    }
                    i++;
                }
            } else {
                int i = 25;
                while (i >= 0) {
                    if (times[i] > 0) {
                        times[i] = times[i] - 1;
                        ans[index++] = (char)(i + 97);
                    }
                    i--;
                }
            }
            up = !up;
        }

        return new String(ans);
    }


}
