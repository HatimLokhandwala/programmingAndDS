package strings;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
Given a string, remove all duplicates and return the lexicographically smallest possible subsequence
 */
public class RemoveDuplicates {
    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        String output = "";
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length();i++) {
            if (!set.contains(s.charAt(i))) {
                while (!st.isEmpty() && st.peek() > s.charAt(i)
                        && map.getOrDefault(st.peek(), -1) > i) {
                    char top = st.pop();
                    set.remove(top);
                }
                set.add(s.charAt(i));
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()) {
            output = st.pop() + output;
        }
        return output;
    }

    public static void main(String[] args) {
        Assert.check(removeDuplicateLetters("abcba").equals("abc"));
        Assert.check(removeDuplicateLetters("cbaba").equals("cab"));
        Assert.check(removeDuplicateLetters("cbacdcbc").equals("acdb"));
    }
}
