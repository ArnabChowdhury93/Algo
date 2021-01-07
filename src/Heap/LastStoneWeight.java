/**
 *
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/
 *
 */
class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 - stone2 != 0) {
                maxHeap.offer(Math.abs(stone1 - stone2));
            }
        }

        if (maxHeap.size() == 0) {
            return 0;
        } else {
            return maxHeap.peek();
        }
    }
}