/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/submissions/
 */
class PartitionEqualSubsetSumRecursive{
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        boolean[][] memo = new boolean[nums.length][sum/2 +1];
        return canPartitionRecursive(nums, memo, sum/2, 0);
    }

    private boolean canPartitionRecursive(int[] nums, boolean[][] memo, int sum, int currentIndex){
        if(sum==0){
            return true;
        }

        if(currentIndex>=nums.length){
            return false;
        }

        if(memo[currentIndex][sum] == false){
            if(nums[currentIndex]<=sum){
                if(canPartitionRecursive(nums, memo, sum - nums[currentIndex], currentIndex+1)){
                    memo[currentIndex][sum] = true;
                    return true;
                }
            }
        }

        memo[currentIndex][sum] = canPartitionRecursive(nums, memo, sum, currentIndex+1);

        return memo[currentIndex][sum];

    }
}