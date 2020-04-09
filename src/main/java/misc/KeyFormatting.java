package misc;
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder s = new StringBuilder();

        if (S == null || S.length() == 0|| K <= 0) {
            return S;
        }
        int dashCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                dashCount++;
            }
        }
        int charCount = S.length() - dashCount;
        int firstGroupSize = charCount % K;
        String output = "";
        int index = 0;
        if (firstGroupSize != 0) {
            while (firstGroupSize != 0) {
                output += Character.toUpperCase(S.charAt(index++));
                firstGroupSize--;
            }
            if (index != S.length()) {
                output += "-";
            }
        }
        int count = 0;
        while (index < S.length()) {
            if (S.charAt(index) == '-') {
                index++;
                continue;
            }
            if (count == K) {
                count = 0;
                output += "-";
            }
            output += Character.toUpperCase(S.charAt(index));
            index++;
            count++;
        }
        return output;
    }
}

public class KeyFormatting {


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(s.licenseKeyFormatting("5F3Z-2e-9-w9", 4));
        System.out.println(s.licenseKeyFormatting("5F3Z", 4));
    }
}
