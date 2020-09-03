package com.leet.google.bundle;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/26 10:36
 */
public class LocalCache {

    private static Cache<String, Integer> cache = CacheBuilder.newBuilder().maximumSize(3)
            .expireAfterWrite(1000, TimeUnit.MILLISECONDS).build();

    public static void main(String[] args) throws ExecutionException {
        cache.get("1", new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });


        cache.get("2", new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });

        int num = cache.get("1", new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 7;
            }
        });
        System.out.println(num);
        System.out.println(cache.size());
    }


}
