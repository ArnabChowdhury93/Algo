/**
 *
 *
 * K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/submissions/
 */
class ClosestKPointsFromOrigin{
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> (square(p2) - square(p1)));
        for(int i = 0; i < k; i++){
            pq.add(points[i]);
        }
        if(points.length > k){
            for(int i = k; i < points.length; i++){
                if(square(points[i]) < square(pq.peek())){
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }
        return pq.toArray(new int[k][]);
    }

    public int square(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}