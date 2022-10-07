package spatel.algo.linkedList;
/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Input: head = [1,2,3,4,5], n = 2  =====>  Output: [1,2,3,5]
 * 
 * Input: head = [1,2], n = 1     =====> Output: [1]
 * 
 * Input: head = [1], n = 1       =====> Output: []
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n ==1))
            return null;
        
        ListNode fast = head;
        int i = 0;
        for( ; i < n && fast != null; i++){
            fast = fast.next;
        }
        
        ListNode slow = head, prev = null;
        if(fast == null && i == n){
            return head.next; 
        }else if(fast == null){
            head = prev;
        }else{
            while(fast != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = slow.next;
        }    
        
        return head;
    }
}
