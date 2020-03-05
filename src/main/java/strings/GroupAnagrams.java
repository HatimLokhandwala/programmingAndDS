package strings;

import java.util.*;
/**
 * Given an array of strings, group anagrams together.
 * Created by hatim.lokhandwala on 05/03/20
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> list = map.getOrDefault(sorted, new ArrayList<String>());
            list.add(str);
            map.put(sorted, list);
        }
        List<List<String>> output = new ArrayList<>();
        for (String key: map.keySet()) {
            output.add(map.get(key));
        }
        return output;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

}
