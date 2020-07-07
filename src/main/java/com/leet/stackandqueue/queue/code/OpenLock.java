package com.leet.stackandqueue.queue.code;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/24 19:43
 */
public class OpenLock {

    private Set<String> seen = new HashSet<String>();

    public int openLock(String[] deadends, String target) {
        String zero = "0000";
        int ans = -1;
        if (isContain(zero, deadends)) {
            return -1;
        }
        Queue<String> queue = new LinkedBlockingQueue<String>();
        queue.offer(zero);
        seen.add(zero);

        while (true) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return ans;
                }
                queue.addAll(rotate(poll, deadends));

            }
            if (queue.size() == 0) {
                return -1;
            }
        }
    }

    private boolean isContain(String str, String[] deadends) {
        for (String s : deadends) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }


    public List<String> rotate(String str, String[] deadends) {
        if (str.equals("1202")) {
            System.out.println(str);
            System.out.println(seen);
        }

        List<String> rotates = new ArrayList<String>(8);
        for (int i = 0; i < str.length(); i++) {
            int v = Integer.parseInt(str.substring(i, i + 1));

            int add = (v + 1) % 9;
            String addStr = str.substring(0, i) + add + str.substring(i + 1);
            if (!isContain(addStr, deadends) && !seen.contains(addStr)) {
                rotates.add(addStr);
                seen.add(addStr);
            }

            int del = v == 0 ? 9 : v - 1;
            String delStr = str.substring(0, i) + del + str.substring(i + 1);

            if (!isContain(delStr, deadends) && !seen.contains(delStr)) {
                rotates.add(delStr);
                seen.add(delStr);
            }
        }
        return rotates;
    }


    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String[] deadends2 = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String[] deadends3 = new String[]{"8888"};


        String str = "8888";
        System.out.println(new OpenLock().openLock(deadends2, str));
    }

}
