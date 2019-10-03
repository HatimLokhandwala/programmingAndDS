package DynamicProgramming;

/**
 * Created by hatim.lokhandwala on 05/07/19.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Eg:  i/p : 12
 * 		o/p : 2 (AB or L)
 * 		i/p : 226
 * 		o/p : BBF, BZ, VF
 */

public class WaysToDecode {
	public static int numDecodings(String A) {
		int len = A.length();
		if(len == 0 || A.charAt(0) == '0') {
			return 0;
		}
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 1; i < A.length(); i++) {
			char ch = A.charAt(i);
			char chPrev = A.charAt(i-1);
			int number = (chPrev - 48) * 10 + (ch - 48);
			if(ch != '0') {
				dp[i+1] = dp[i];
			}
			if(number <= 26 && number >= 10) {
				dp[i+1] += dp[i-1];
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("261155971756562"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("12"));
	}

}


