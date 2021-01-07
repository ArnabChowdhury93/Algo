class KnacpsackRecursiveDP {
    public int getMaxProfit(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity];
        return knapsackRecursive(profits, weights, dp, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int[][] dp, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        if (null != dp[currentIndex][capacity]) {
            return dp[currentIndex][capacity];
        }

        int profit1 = 0;
        if (weight[currentIndex] <= capacity) {
            profit1 = weights[currentIndex] + knapsackRecursive(profits, weights, dp,
                    capacity - weights[currentIndex], currentIndex + 1);
        }
        int profit2 = knapsackRecursive(profits, weights, dp,
                capacity - weights[currentIndex], currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

}
