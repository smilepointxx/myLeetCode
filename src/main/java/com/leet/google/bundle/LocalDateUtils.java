package com.leet.google.bundle;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/8/26 14:59
 */
public class LocalDateUtils {

    public static void main(String[] args) throws ParseException {
        Node node = new Node();
        System.out.println(node.toString());
    }



    static class Node {
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
