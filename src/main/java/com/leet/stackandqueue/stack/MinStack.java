package com.leet.stackandqueue.stack;

import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-06-28.
 */
public class MinStack {

    private Stack<Integer> minNum;

    private Stack<Integer> num;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minNum = new Stack<Integer>();
        num = new Stack<Integer>();
    }

    public void push(int x) {
        if (!num.empty()) {
            minNum.push(Math.min(minNum.peek(), x));
        } else {
            minNum.push(x);
        }
        num.push(x);

    }

    public void pop() {
        if (!num.empty()) {
            num.pop();
            minNum.pop();
        }
    }

    public int top() {
        if (!num.empty()) {
            return num.peek();
        }
        return 0;
    }

    public int getMin() {
        if (num.empty()) {
            return 0;
        } else {
            return minNum.peek();
        }
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.println(obj.getMin());
        int param_3 = obj.top();
        System.out.println(param_3);
        obj.pop();
        int param_4 = obj.getMin();
        System.out.println(param_4);


    }

}
