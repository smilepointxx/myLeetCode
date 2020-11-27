package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/19 11:37
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (heap(gas, cost, i)) {
                return i;
            }
        }
        return -1;

    }

    public boolean heap(int[] gas, int[] cost, int n) {
        int sumGas = 0;
        int sumCost = 0;
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int index = (i + n) % length;
            sumGas += gas[index];
            sumCost += cost[index];
            if (sumGas < sumCost) {
                return false;
            }
        }
        return true;
    }

}
