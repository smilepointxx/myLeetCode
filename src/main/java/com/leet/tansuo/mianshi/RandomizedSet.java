package com.leet.tansuo.mianshi;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/23 11:23
 */
public class RandomizedSet {

    public Map<Integer, Integer> map;
    public Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            map.put(val, val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Object[] keys = map.keySet().toArray();
        return (int)keys[random.nextInt(keys.length)];
    }

    public static void main(String[] str) {
        Random random = new Random(20);
        System.out.println(random.nextInt(10));
    }

}
