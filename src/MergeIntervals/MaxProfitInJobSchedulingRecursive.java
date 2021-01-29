/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 */
class MaxProfitInJobSchedulingRecursive{

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs, Comparator.comparingInt(j -> j.end));

        return findMaxProfit(jobs,jobs.size());
    }

    private static int findMaxProfit(List<Job> jobs, int n) {
        if(n==1){
            return jobs.get(n-1).profit;
        }
        int includeCurrentProfit = jobs.get(n-1).profit;
        int nextProfitIndex = findNextPossibleProfitIndex(jobs, n);
        if(nextProfitIndex != -1){
            includeCurrentProfit += findMaxProfit(jobs, nextProfitIndex+1);
        }
        int excludeCurrentProfit = findMaxProfit(jobs, n-1);
        return Math.max(includeCurrentProfit, excludeCurrentProfit);
    }

    private static int findNextPossibleProfitIndex(List<Job> jobs, int n) {
        for(int i = n-1; i >= 0; i--){
            if(jobs.get(n-1).start >= jobs.get(i).end){
                return i;
            }
        }
        return -1;
    }
}