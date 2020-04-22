import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONSTANT = 1.96;
    private double mean;
    private double stdDeviation;
    private final int trials;
    private double[] thresholds;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (trials <= 0) {
          throw new IllegalArgumentException("Incorrect trial value " + trials + " Should be greater than 0");
        }
        this.trials = trials;
        thresholds = new double[trials];
        mean = 0;
        stdDeviation = 0;
        performSimulations(n);
    }

    private void performSimulations(int n) {
        int squareOfN = n * n;
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = 1 + StdRandom.uniform(n);
                int col = 1 + StdRandom.uniform(n);
                p.open(row, col);
            }
            thresholds[i] = p.numberOfOpenSites() / (double) squareOfN;
        }
        mean = StdStats.mean(thresholds);
        stdDeviation = StdStats.stddev(thresholds);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stdDeviation;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((CONSTANT * stdDeviation) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + ((CONSTANT * stdDeviation) / Math.sqrt(trials));
    }

    private void printStats() {
        System.out.println("mean = " + mean());
        System.out.println("stddev = " + stddev());
        System.out.println("95% confidence interval = [" + confidenceLo() + ", " + confidenceHi() + "]");
    }


    public static void main(String[] args) {
        // empty method body
    }
}
