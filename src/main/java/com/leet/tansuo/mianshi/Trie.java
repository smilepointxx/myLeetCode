package com.leet.tansuo.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/22 18:15
 */
public class Trie {

    TreeNode head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        insertHelp((word + " ").toCharArray(), 0, head);
    }

    public void insertHelp(char[] chars, int index, TreeNode current) {
        if (index >= chars.length) {
            return;
        }
        char c = chars[index];
        List<TreeNode> nextNodes = current.next;

        for (TreeNode node : nextNodes) {
            if (node.current == c) {
                insertHelp(chars, index + 1, node);
                return;
            }
        }
        TreeNode newNode = new TreeNode(c);
        nextNodes.add(newNode);
        insertHelp(chars, index + 1, newNode);


    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchAndStartWith(word, " ");
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchAndStartWith(prefix, "");
    }

    public boolean searchAndStartWith(String w, String p) {
        TreeNode node = head;
        char[] chars = (w + p).toCharArray();
        int index = 0;
        while(index < chars.length) {
            boolean is = false;
            List<TreeNode> nodes = node.next;
            for (TreeNode treeNode : nodes) {
                if (treeNode.current == chars[index]) {
                    index++;
                    node = treeNode;
                    is = true;
                    break;
                }
            }
            if (!is) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] str) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }

}

class TreeNode {
    char current;

    List<TreeNode> next;

    public TreeNode() {
        next = new ArrayList<>();
    }

    public TreeNode(char current) {
        this.current = current;
        next = new ArrayList<>();
    }
}


