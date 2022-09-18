package spatel.algo.linkedList;

public class ReversePartOfLinkedList {

	public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        
        ListNode current = head;
        ListNode revPrev = null;
        for(int i=1; i < left ;  i++ ){
           if(current != null){
               revPrev = current;
               current = current.next;
           } 
        }
        
        ListNode lastNodeOfSecondPart = current;
        
        ListNode prev = null;  
        for(int i = left; i <= right; i++){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
        }
        
        lastNodeOfSecondPart.next = current;
        
        if(revPrev != null)
            revPrev.next = prev;
        
        
        return revPrev == null ? prev:head;
    }
}
