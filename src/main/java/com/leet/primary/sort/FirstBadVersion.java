package com.leet.primary.sort;

/**
 * mac os
 * Created by smile on 2020-07-18.
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        if (n < 1) {
            return n;
        }

        int p1 = 1;
        int p2 = n;

        while (p1 < p2) {
            int mid = p1 + (p2 - p1) / 2;
            if (isBadVersion(mid)) {
                p1 = mid + 1;
            } else {
                p2 = mid;
            }
        }
        return p1;

        


    }

    public boolean isBadVersion(int n) {
        return n > 10;
    }

}
