/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervals{
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] interval = intervals[0];
        List<int[]> mergedList = new ArrayList<>();
        for(int i=1; i < intervals.length; i++){
            int[] temp = intervals[i];
            if(interval[1] >= temp[0]){
                interval[1] = interval[1] >= temp[1] ? interval[1] : temp[1];
            }
            else{
                mergedList.add(interval);
                interval = intervals[i];
            }
        }
        mergedList.add(interval);
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}