package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/21 17:49
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        int i = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }


    public static void main(String[] args) {
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        boolean longPressedName = isLongPressedName.isLongPressedName("pyplrz", "ppyypllr");
        System.out.println(longPressedName);
    }
}
