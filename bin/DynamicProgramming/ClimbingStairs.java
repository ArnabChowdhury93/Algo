/**
 *
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/submissions/
 *
 */
class ClimbingStairs {
    public int climbStairsDP(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 2];
        dp[1] = 1;
        for (int i = 2; i < n + 2; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n + 1];
    }

    public int climbStairs(int n) {
        if(n<=1){
            return n;
        }
        int val1 = 0;
        int val2 = 1;
        int val3 = 0;
        for(int i=2; i < n+2; i++){
            val3 = val1 + val2;
            val1 = val2;
            val2 = val3;
        }
        return val3;
    }
}