class ConnectKRopes{
    public int mergeStones(int[] stones, int k) {
        if(stones.length < k){
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < stones.length; i++){
            minHeap.add(stones[i]);
        }
        int cost = 0;
        while(minHeap.size() > 1){
            if(minHeap.size() < k){
                return -1;
            }
            int currentCost = 0;
            for(int i = 0; i < k; i++){
                currentCost += minHeap.poll();
            }
            cost += currentCost;
            minHeap.add(currentCost);
        }
        return cost;
    }
}