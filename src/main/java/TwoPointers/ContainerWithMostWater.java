package TwoPointers;

/**
 * Created by hatim.lokhandwala on 09/04/20
 * Given n non-negative integers a1, a2, ..., an.
 * vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int start = 0;
        int end = length - 1;
        int maxArea = 0;
        while (start < end) {
            int min = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, min * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
    //Brute Force solution
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int min = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, min * (j - i));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
