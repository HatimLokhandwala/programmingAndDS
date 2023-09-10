package combinatorics;

/**
 * Problem: Given n orders, each order consist in pickup and delivery services.
 *
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class CountWaysForDelivery {
    /**
     * Approach: Lets say we have combination available for n - 1 pairs and we need to add the nth Pair
     * for adding the pick up we have 2 * n - 1 available positions
     * for adding the delivery  we have 2 * n available positions (since we added the pick up above)
     * so no of ways = ( 2 * n - 1) * (2 * n)
     * since pick up has to be before the delivery total ways is reduced to half
     * total ways = ( 2 * n - 1) * n
     * this ways can be multiplied at each step with result ways we have so far.
     * @param n No of items to pick and deliver
     * @return total no of ways to deliver.
     */
    public int countOrders(int n) {
        long res = 1;
        long mod = (long)1e9 + 7;
        for (int i = 1; i <= n; i++) {
            res = (((i * 2 - 1) * i) * res) % mod;
        }
        return (int)res;
    }

}
