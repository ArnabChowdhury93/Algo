/**
 * 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/
 *
 */
class IntervalListIntersections{
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0; int j = 0;
        List<int[]> intersections = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            if((firstList[i][0] <= secondList[j][0] && secondList[j][0] <= firstList[i][1]) ||
                    (secondList[j][0] <= firstList[i][0] && firstList[i][0] <= secondList[j][1])){
                intersections.add(new int[]{Math.max(firstList[i][0], secondList[j][0]),
                        Math.min(firstList[i][1], secondList[j][1])});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
        }
        return intersections.toArray(new int[intersections.size()][]);
    }
}