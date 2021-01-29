/**
 *
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
 *
 */
class KthLargestElementInStream{
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public final int k;
    public KthLargest(int k, int[] nums) {
        this.k  = k;
        for(int i = 0; i < nums.length && i < k; i++){
            pq.add(nums[i]);
        }
        if(nums.length > k){
            for(int i = k; i < nums.length; i++){
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if(pq.size() < this.k){
            pq.add(val);
        }
        else if(pq.peek() < val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
}