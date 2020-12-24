package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/10 11:55
 */
public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            int k = bill - 5;
            switch (k) {
                case 5:
                    five--;
                    break;
                case 10:
                    if (ten > 0) {
                        ten--;
                    } else {
                        five -= 2;
                    }
                    break;
                case 15:
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                    break;
            }

            if (ten < 0 || five < 0) {
                return false;
            }
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                ten++;
            }
        }
        return true;
    }

}
