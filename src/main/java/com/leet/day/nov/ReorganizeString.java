package com.leet.day.nov;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/30 10:51
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int[] array = new int[26];
        for (char c : S.toCharArray()) {
            array[(int) c - 97]++;
        }
        Queue<NodeChar> queue = new PriorityQueue<>(26, new Comparator<NodeChar>() {
            @Override
            public int compare(NodeChar o1, NodeChar o2) {
                return o2.n - o1.n;
            }
        });
        for (int index = 0; index < 26; index++) {
            if (array[index] != 0) {
                queue.offer(new NodeChar((char)(index + 97), array[index]));
            }
        }
        int length = S.length();
        int oddNum = 0;
        int odd = length / 2;
        int evenNum = 0;
        int even = odd + length % 2;
        char[] ans = new char[length];
        while (!queue.isEmpty()) {
            NodeChar node = queue.poll();
            int o = odd - oddNum;
            int e = even - evenNum;
            if (node.n > Math.max(o, e)) {
                return "";
            }
            for (int i = 0; i < node.n; i++) {
                if (evenNum * 2 < length) {
                    ans[evenNum * 2] = node.c;
                    evenNum ++;
                } else {
                    ans[oddNum * 2 + 1] = node.c;
                    oddNum ++;
                }
            }
        }
        return new String(ans);

    }

    class NodeChar {
        char c;
        int n;

        public NodeChar(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        String str = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuve" +
                "ompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmu" +
                "ygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovd" +
                "ojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrph" +
                "aykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounl" +
                "dxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvk" +
                "nprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnup" +
                "nukayjghpusewdwrbkhvjnveuiionefmnfxao";
        System.out.println(reorganizeString.reorganizeString(str));
    }


}
