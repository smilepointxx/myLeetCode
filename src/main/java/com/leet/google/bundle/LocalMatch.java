package com.leet.google.bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/27 15:49
 */
public class LocalMatch {

    public static void main(String[] args) {
        String reg = "\\D";
        String str = "17629019";
        System.out.println(str.substring(0, str.length() - 1));
        Matcher matcher = Pattern.compile(reg).matcher(str.substring(0, str.length() - 1));
        boolean b = matcher.find();
        System.out.println(b);
    }

}
