import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
class Trie {

    class TrieNode {
        private boolean terminal;
        private TrieNode[] arr;
        TrieNode() {
            terminal = false;
            arr = new TrieNode[26];
        }
        public boolean isTerminal() {
            return terminal;
        }
        public void setTerminal() {
            terminal = true;
        }
        public boolean containsChar(char c) {
            return arr[c - 97] != null;
        }
        public void put(char c, TrieNode node) {
            arr[c-97] = node;
        }

        public TrieNode getNode(char c) {
            return arr[c-97];
        }

    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(current.containsChar(c)) {
                current = current.getNode(c);
            } else {
                TrieNode newNode = new TrieNode();
                current.put(c, newNode);
                current = newNode;
            }
        }
        current.setTerminal();
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(!current.containsChar(c)) {
                return false;
            }
            current = current.getNode(c);
        }
        return current.terminal;
    }




    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!current.containsChar(c)) {
                return false;
            }
            current = current.getNode(c);
        }
        return true;
    }
    List<String> output = new ArrayList<>();
    List<String> getMatching(String s) {
        TrieNode current = root;
        output = new ArrayList<>();
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (!current.containsChar(c)) {
                return output;
            }
            current = current.getNode(c);
        }

        traverse(current, "");
        return output;
    }

    void traverse(TrieNode current, String temp) {
        if(current == null) {
            output.add(new String(temp));
            return;
        }
        for(int i = 0; i<26;i++){
            char c = (char)(i + 97);

            if(current.containsChar(c)) {
                traverse(current.getNode(c), temp + c);
            }
        }
    }
}

class Solution {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        for(String product: products) {
            t.insert(product);
        }
        List<List<String>> lists = new ArrayList<>();
        String se = "";
        for(int i = 0; i< searchWord.length(); i++) {
            se += searchWord.charAt(i);
            List<String> res = t.getMatching(se);
            List<String> resCopy = new ArrayList<>(res);
            Collections.sort(resCopy);
            List<String> ans = new ArrayList<>();
            if(resCopy.size() == 1) ans.add(resCopy.get(0));
            if(resCopy.size() == 2) ans.add(resCopy.get(1));
            if(resCopy.size() == 3) ans.add(resCopy.get(2));
            lists.add(ans);
        }
        return lists;
    }

    public static void main(String[] args) {
        String p[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        suggestedProducts(p, "mouse");
    }
}

