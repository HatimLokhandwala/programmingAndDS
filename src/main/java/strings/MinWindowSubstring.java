package strings;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T
 * Eg: S = "aaadbcaa"
 * T = "abca"
 * ans = "bcaa"
 */

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        counter = t.length();
        int start = 0, end = 0;
        int[] ans = {Integer.MAX_VALUE, -1, -1};
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    counter--;
                }
            }
            while (counter == 0 && start <=end) {
                if ((end - start + 1) < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                char sCh = s.charAt(start);
                if (map.containsKey(sCh)) {
                    map.put(sCh, map.get(sCh) + 1);
                    if (map.get(sCh) >= 1) {
                        counter++;
                    }
                }
                start++;
            }
            end++;
        }
        if (ans[0] == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(ans[1], ans[2] + 1);
    }

}
