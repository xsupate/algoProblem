package spatel.algo.linkedList;

/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) 
            return head;
        
        ListNode current = head, prev=null;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        } 
        
        current = head;
        
        while(true && count >= k){
           ListNode lastNodeOfPrevSubList = prev;
           ListNode lastNodeOfSubList = current;
            
           for(int i = 0;  current != null && i < k ;  i++){
               ListNode next = current.next;
               current.next = prev;
               prev = current;
               current = next;
               count--;
           }
            
           if(lastNodeOfPrevSubList != null){
               lastNodeOfPrevSubList.next = prev;
           } else{
               head = prev;
           }
            
            lastNodeOfSubList.next = current; 
            
           if(current == null){
               break;
           }
            
           prev =  lastNodeOfSubList;
        }
        
        return head;
    }
}
