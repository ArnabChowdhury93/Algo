/**
 *
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
class MeetingRooms{
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        Collections.sort(meetings, Comparator.comparingInt(m -> m.start));
        Queue<Meeting> minHeap = new PriorityQueue<Meeting>(Comparator.comparing(m -> m.end));
        int minRooms = 0;
        for(Meeting meeting : meetings){
            while(!minHeap.isEmpty() && minHeap.peek().end <= meeting.start){
                minHeap.poll();
            }
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}