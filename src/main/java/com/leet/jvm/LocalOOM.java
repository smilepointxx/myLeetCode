package com.leet.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/27 18:13
 */
public class LocalOOM {

    static class OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int count = 0;
        while (true) {
            list.add(new OOMObject());
            count++;
            System.out.println(count);
            if (count > 300000) {
                System.gc();
            }
        }
    }

}
