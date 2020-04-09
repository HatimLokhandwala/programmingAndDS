package strings;

import java.util.Collections;
import java.util.*;

/**
 * Given a string of words, reverse it word by word
 * Eg: Input  - my name is sachin
 *     Output - sachin is name my
 */

public class ReverseWords {

    //Approach I : using inbuilt functions
    public static String reverseWords1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        StringBuilder b = new StringBuilder();
        for(String word: list) {
            b.append(word).append(" ");
        }
        return b.substring(0, b.length() -1);
    }

    //Approach II : reverse whole string, reverse word by word
    public static String reverseWords(String s) {
        s = s.trim();
        s = reverse(s);
        int index = 0;
        int lastIndex = 0;
        boolean clear = false;
        String output = "";
        while(index < s.length()) {
            while(index < s.length() && s.charAt(index) != ' ') {
                index++;
            }
            output += reverse(s.substring(lastIndex, index)) + " ";
            while(index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            lastIndex = index;
        }

        return output.length() == 0 ? "" : output.substring(0, output.length() - 1);
    }

    static String reverse(String input) {
        char[] arr = input.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("my name is sachin"));
    }

}
