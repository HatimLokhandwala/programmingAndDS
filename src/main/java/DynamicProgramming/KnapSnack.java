package DynamicProgramming;

public class KnapSnack {


    static int recursion(int n, int W, int[] wt, int[] val) {
        if (n == 0 || W == 0) {
            return 0;
        }
        return recursiveUtil(0, n, W, wt, val);
    }

    private static  int recursiveUtil(int i, int n, int w, int[] wt, int[] val) {
        if (i == n) {
            return 0;
        }
        int profit = 0;
        if (w - wt[i] >= 0) {
            profit = val[i] + recursiveUtil(i + 1, n, w - wt[i], wt, val);
        }
        profit = Math.max(profit, recursiveUtil(i + 1, n, w, wt, val));
        return profit;
    }

    public static void main(String[] args) {
//        System.out.println(recur);
    }
}
