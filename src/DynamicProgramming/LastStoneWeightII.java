/**
 *
 * 1049. Last Stone Weight II
 * https://leetcode.com/problems/last-stone-weight-ii/
 *
 */
class LastStoneWeightII{
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }

        boolean[][] dp = new boolean[n][sum/2 + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        for(int s = 1; s <= sum/2; s++){
            if(s == stones[0]){
                dp[0][s] = true;
            }
            else{
                dp[0][s] = false;
            }
        }

        for(int i = 1; i < n; i++){
            for(int s = 1; s <= sum/2; s++){
                if(dp[i-1][s]){
                    dp[i][s] = true;
                }
                else if(s>=stones[i]){
                    dp[i][s] = dp[i-1][s-stones[i]];
                }
            }
        }

        int sum1=0, sum2=0;
        for(int s=sum/2; s>=0; s--){
            if(dp[n-1][s]){
                sum1 = s;
                break;
            }
        }
        sum2 = sum - sum1;

        return Math.abs(sum1-sum2);
    }

}