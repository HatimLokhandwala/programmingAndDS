package dp;

/**
 * Created by hatim.lokhandwala on 05/07/19.
 */
public class WaysToDecode {
	public static int numDecodings(String A) {
		int strLen = A.length();
		if(A == null || strLen == 0) {
			return 0;
		}
		int[] dp = new int[strLen + 1];
		dp[0] = 1;
		dp[1] = 1;
		if(A.charAt(0) == '0') {
			dp[1] = 0;
		}
		int ways = 0;
		for(int i = 1; i < strLen; i++) {
			int number = A.charAt(i) - 48;
			if(number == 0) {
				if(A.charAt(i - 1) > 50 || A.charAt(i - 1) == 48) {
					return 0;
				}
				dp[i + 1] = dp[i - 1];
			} else {
				ways = dp[i];
				int twoDigitNum = ((A.charAt(i - 1) - 48) * 10 + number);
				if( twoDigitNum <= 26 && twoDigitNum >= 10) {
					ways += dp[i - 1];
				}
				dp[i + 1] = ways;
			}
		}
		return dp[strLen];
	}

	public static void main(String[] args) {
		numDecodings("2611055971756562");
	}

}
