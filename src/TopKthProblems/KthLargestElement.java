/**
 *
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
 */
class KthLargestElement{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < k; i++){
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
        return pq.poll();
    }
}