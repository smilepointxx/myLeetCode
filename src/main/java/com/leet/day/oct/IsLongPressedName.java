package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/21 17:49
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0 || typed == null || typed.length() == 0 || typed.length() < name.length()) {
            return false;
        }
        char cuu = name.charAt(0);
        int countNum = 1;
        int index = 0;
        for (int i = 1; i < name.length(); i++) {
            if (cuu == name.charAt(i)) {
                countNum++;
            } else {
                index = helper(typed, index, countNum, cuu);
                if (index == 0) {
                    return false;
                }
                cuu = name.charAt(i);
                countNum = 0;
            }
        }
        return true;
    }

    private int helper(String typed, int index, int countNum, char c) {
        int count = 0;
        int reId = index;
        for (int i = index; i < typed.length(); i++) {
            if (c == typed.charAt(i)) {
                count++;
                reId = i;
            } else {
                break;
            }
        }
        if (count >= countNum) {
            return reId + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        boolean longPressedName = isLongPressedName.isLongPressedName("saeed", "ssaaedd");
        System.out.println(longPressedName);
    }
}
