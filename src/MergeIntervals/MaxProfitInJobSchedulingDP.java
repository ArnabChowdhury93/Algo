/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 */
class MaxProfitInJobSchedulingDP{
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs, Comparator.comparingInt(j -> j.end));

        return findMaxProfit(jobs,jobs.size());
    }

    private static int findMaxProfit(List<Job> jobs, int n) {
        int[] dp = new int[n];
        dp[0] = jobs.get(0).profit;
        for(int i = 1; i < n; i++){
            int includeCurrentProfit = jobs.get(i).profit;
            int nextProfitIndex = findNextPossibleProfitIndex(jobs, i);
            if(nextProfitIndex != -1){
                includeCurrentProfit += dp[nextProfitIndex];
            }
            dp[i] = Math.max(includeCurrentProfit,dp[i-1]);

        }
        return dp[n-1];
    }

    private static int findNextPossibleProfitIndex(List<Job> jobs, int n) {
        for(int i = n-1; i >= 0; i--){
            if(jobs.get(n).start >= jobs.get(i).end){
                return i;
            }
        }
        return -1;
    }
}