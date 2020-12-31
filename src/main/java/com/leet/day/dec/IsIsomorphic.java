package com.leet.day.dec;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/27 13:02
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = mapS.get(s.charAt(i));
            if (c != null && t.charAt(i) != c) {
                return false;
            } else if (c == null && mapT.get(t.charAt(i)) != null){
                return false;
            } else {
                mapS.put(s.charAt(i), t.charAt(i));
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

}
