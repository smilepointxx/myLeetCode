package com.leet.primary.design;

import java.util.ArrayList;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class FizzBuzz {


    public List<String> fizzBuzz(int n) {
        String str3 = "Fizz";
        String str5 = "Buzz";
        String str35 = "FizzBuzz";
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            switch (help(i)) {
                case 3:
                    ans.add(str3);
                    break;
                case 5:
                    ans.add(str5);
                    break;
                case 35:
                    ans.add(str35);
                    break;
                case 0:
                    ans.add(i + "");
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    public int help(int n) {
        int p1 = n % 3;
        int p2 = n % 5;
        if (p1 == 0 && p2 == 0) {
            return 35;
        } else if (p1 == 0) {
            return 3;
        } else if (p2 == 0) {
            return 5;
        } else {
            return 0;
        }
    }

}
