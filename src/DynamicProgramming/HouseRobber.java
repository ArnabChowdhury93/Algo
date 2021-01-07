/**
 *
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 *
 */
class HouseRobber{
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int val1 = nums[0];
        if(n == 1){
            return val1;
        }
        int val2 = Math.max(val1, nums[1]);
        if(n == 2){
            return val2;
        }

        int max = 0;
        for(int i = 2; i < n; i++){
            max = Math.max(val1 + nums[i], val2);
            val1 = val2;
            val2 = max;
        }
        return max;
    }

}