package com.leet.stackandqueue.queue.circular;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 21:13
 */
public class Main {

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(5);
        boolean param_1 = obj.enQueue(7);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }

}
