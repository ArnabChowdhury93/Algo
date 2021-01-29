/**
 *
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/
 *
 */
class TopKFrequentElements{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() -
                e2.getValue());
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] topKFrequentElements = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            topKFrequentElements[i++] = minHeap.poll().getKey();
        }
        return topKFrequentElements;
    }
}