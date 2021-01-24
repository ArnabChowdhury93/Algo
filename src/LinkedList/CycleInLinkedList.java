/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 142. Linked List Cycle II
 *
 */
class CycleInLinkedList{

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                while(slow != start){
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }

        }

        return null;
    }

}