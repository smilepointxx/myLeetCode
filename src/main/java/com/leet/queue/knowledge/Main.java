package com.leet.queue.knowledge;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 20:48
 */
public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(5);
        queue.enQueue(3);
        System.out.println(queue.isEmpty());
    }

}
