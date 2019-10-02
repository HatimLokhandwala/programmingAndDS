package strings;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by hatim.lokhandwala on 23/05/19.
 */
public class LongestSubstring {
	class Sample implements Serializable{

	}
	public static int lengthOfLongestSubstring(String s) {
		// if(s.isEmpty()) return 1;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
//		Collections.reverseOrder()
		int count=0;
		int maxCount = 0;
		int prevIndex =0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(charMap.containsKey(c)){
				int lastIndex = charMap.get(c);
				if(lastIndex>=prevIndex){
					prevIndex = lastIndex + 1;
				}

			}
			maxCount = Math.max(i - prevIndex + 1, maxCount);
			charMap.put(c,i);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
//		StringBuilder s = new StringBuilder();
//		ss.append("adad");
		lengthOfLongestSubstring("abc");
	}
}
