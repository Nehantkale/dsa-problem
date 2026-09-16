class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        long[][] dp = new long[n][k + 1];
        long[][] open = new long[n][k + 1];

        // At point 0:
        // 0 segments = 1 way
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                // Do nothing with point i
                dp[i][j] = dp[i - 1][j];

                // If a segment is currently open,
                // extend it to point i
                if (j > 0) {
                    open[i][j] = open[i - 1][j];
                }

                // Start a new segment at point i
                if (j > 0) {
                    open[i][j] += dp[i - 1][j - 1];
                }

                open[i][j] %= MOD;

                // Close the currently open segment at i
                dp[i][j] += open[i][j];

                dp[i][j] %= MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}