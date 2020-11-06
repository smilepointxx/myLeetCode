package com.leet.day.nov;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/5 15:51
 */
public class Limit {

    RateLimiter limiter = RateLimiter.create(20);

    public void test() {

        for (int i = 0;i < 10; i++) {
            new Thread(() -> {
                if (limiter.tryAcquire(1)) {
                    System.out.println("success" + limiter.getRate());
                } else {
                    System.out.println("failed");
                }
            }).start();

        }

    }


    public static void main(String[] args) throws InterruptedException {

        Stopwatch stopwatch = Stopwatch.createStarted();
        long begin = System.currentTimeMillis();
        Thread.sleep(100);
        stopwatch.stop();



        Limit limit = new Limit();
        limit.test();
    }

}
