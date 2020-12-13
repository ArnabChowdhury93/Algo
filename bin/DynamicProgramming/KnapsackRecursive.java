class KnapsackRecursive {
    public int getMaxProfit(int[] profits, int[] weights, int capacity) {
        knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex],
                    currentIndex + 1);
        }

        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}