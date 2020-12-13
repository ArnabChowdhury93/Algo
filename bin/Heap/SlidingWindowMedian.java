class SlidingWindowMedian {

    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Double> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length-k+1];
        for(int i=0; i<nums.length; i++){
            if(maxHeap.isEmpty() || maxHeap.peek()>=nums[i]){
                maxHeap.add(nums[i]);
            }
            else{
                minHeap.add(nums[i]);
            }
            rebalance();

            if(i-k+1>=0){
                if(maxHeap.size() == minHeap.size()){
                    medians[i-k+1] = (maxHeap.peek() + minHeap.peek())/2.0;
                }
                else{
                    medians[i-k+1] = maxHeap.peek();
                }

                if(nums[i-k+1] <= maxHeap.peek()){
                    maxHeap.remove(nums[i-k+1]);
                }
                else{
                    minHeap.remove(nums[i-k+1]);
                }
                rebalance();
            }
        }

        return medians;
    }

    private void rebalance(){
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args){
        double[] arr = new double[]{2147483647,2147483647};
        double[] medians =  medianSlidingWindow(arr,2);
        System.out.println(medians[0]);
    }
}