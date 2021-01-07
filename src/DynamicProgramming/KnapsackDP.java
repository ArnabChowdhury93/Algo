class KnapsackDP {
    public int knapsackDP(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int c = 0; c <= capacity; i++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                int profits2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profits2);
            }
        }
        return dp[n - 1][capacity];
    }
}
