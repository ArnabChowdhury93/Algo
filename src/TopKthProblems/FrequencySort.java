/**
 *
 *
 *
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/submissions/
 *
 *
 */
class FrequencySort{
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() -
                e1.getValue());
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder sortedString = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry= maxHeap.poll();
            for(int i = 0; i < entry.getValue(); i++){
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }
}