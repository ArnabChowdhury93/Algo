/**
 *
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/submissions/
 */
class InsertInterval{
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return intervals;
        }
        List<int[]> mergedInterval = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            mergedInterval.add(intervals[i++]);
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        mergedInterval.add(newInterval);
        while(i < intervals.length){
            mergedInterval.add(intervals[i++]);
        }
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}