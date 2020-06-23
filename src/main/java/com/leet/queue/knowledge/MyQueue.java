package com.leet.queue.knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 20:38
 */
public class MyQueue {

    public List<Integer> data;

    private int p_start;

    public MyQueue() {
        data = new ArrayList<Integer>();
        p_start = 0;
    }

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        p_start++;
        return true;
    }

    public boolean isEmpty() {
        return p_start >= data.size();
    }

    public int front(){
        return data.get(p_start);
    }


}
