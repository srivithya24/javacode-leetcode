class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        // dp[i][j][k] -> i zeros, j ones, ends with digit k (0 or 1)
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: single block of 0s or 1s within limit
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // Ending with 0: can come from any stable (i-1, j) array
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Subtract cases where adding a 0 creates (limit + 1) consecutive 0s
                    // This specifically removes arrays that ended with 'limit' 0s preceded by a 1
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // Ending with 1: can come from any stable (i, j-1) array
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    // Subtract cases where adding a 1 creates (limit + 1) consecutive 1s
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}