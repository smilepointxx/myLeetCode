package com.leet.day.jan;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/4 18:23
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || flowerbed.length == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 0) {
                if (i + 1 == flowerbed.length || flowerbed[i + 1] == 0) {
                    i += 2;
                    count++;
                } else {
                    i += 3;
                }
            } else {
                i += 2;
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] str) {
        int[] flowerbed = new int[]{
                1,0,1,0,1,0,0,1,0};

        System.out.println(canPlaceFlowers(flowerbed, 1));
    }

}
