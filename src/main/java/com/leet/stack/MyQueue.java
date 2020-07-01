package com.leet.stack;

import java.util.Stack;

/**
 * mac os
 * Created by smile on 2020-06-30.
 */
public class MyQueue {

    //push stack
    private Stack<Integer> stack1;
    //pop stack
    private Stack<Integer> stack2;


    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        obj.push(7);
        while (!obj.empty()) {
            System.out.println(obj.pop());
        }
        System.out.println(obj.empty());


    }

}
