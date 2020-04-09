import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by hatim.lokhandwala on 03/03/20
 */

public class LongestSubString {

    static int determineLongestSubString(String input) {
        if (input == null || input.length() <= 0 ) {
            throw new RuntimeException("incorrect input");
        }
        int maxSubstringLen = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String currentSubStr = input.substring(i, j + 1);
                if (set.contains(currentSubStr)) {
                    maxSubstringLen = Math.max(currentSubStr.length(), maxSubstringLen);
                } else {
                    set.add(currentSubStr);
                }
            }
        }
        return maxSubstringLen;
    }

    public static void main(String[] args) {
        System.out.println(determineLongestSubString("tomato"));
        System.out.println(determineLongestSubString("banana"));
        System.out.println(determineLongestSubString("aaaaaa"));
        System.out.println(determineLongestSubString("ATCGATCGA"));
    }
}
