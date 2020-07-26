package com.leet.middle.huishuo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 16:55
 */
public class GenerateParenthesis {


    List<String> outPut = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n > 0) {
            helper("", n, n);
        }
        return outPut;
    }

    private void helper(String current, int left, int right) {
        //1.左括号剩于个数大于等于又括号
        System.out.println(current);
        if (left == 0 && right == 0) {
            outPut.add(current);
            return;
        }
        if (left > 0) {
            helper(current + "(", left - 1, right);
        }
        if (right > left) {
            System.out.println("right:" + current);
            helper(current + ")", left, --right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

}
