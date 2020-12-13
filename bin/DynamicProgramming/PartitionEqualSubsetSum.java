/**
 *
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 */
class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        sum/=2;

        boolean[][] memo = new boolean[n][sum+1];

        for(int i = 0; i<n; i++){
            memo[i][0] = true;
        }

        for(int s = 1; s < sum; s++){
            if(nums[0] == s){
                memo[0][s] = true;
            }
            else{
                memo[0][s] = false;
            }
        }

        for(int i = 1; i < n; i++){
            for(int s = 1; s <= sum; s++){
                if(memo[i-1][s]){
                    memo[i][s] = true;
                }
                else if(s>=nums[i]){
                    memo[i][s] = memo[i-1][s-nums[i]];
                }
            }
        }

        return memo[n-1][sum];
    }

}