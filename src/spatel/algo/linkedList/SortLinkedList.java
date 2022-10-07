package spatel.algo.linkedList;

public class SortLinkedList {
	public ListNode sortList(ListNode head) {
	       if(head == null || head.next == null)
	           return head;
	        
	        return mergeSort(head);
	    }
	    
	    private ListNode mergeSort(ListNode head){
	        if(head == null || head.next == null){
	            return head;
	        }
	        
	        ListNode midNode = findMidNode(head);
	        ListNode nextToMid = midNode.next;
	        midNode.next = null;
	        
	        ListNode lsl = mergeSort(head);
	        ListNode rsl = mergeSort(nextToMid);
	        return mergeSortedList(lsl,rsl);
	    }    
	    
	    private ListNode mergeSortedList(ListNode head1, ListNode head2){
	        if(head1 == null)
	            return head2;
	        else if(head2 == null)
	            return head1;
	        
	        ListNode result = null;
	        if(head1.val <= head2.val){
	            result = head1;
	            result.next = mergeSortedList(head1.next, head2);
	        }else{
	            result = head2;
	            result.next = mergeSortedList(head1, head2.next);
	        }
	        return result;
	    }
	    
	    private ListNode findMidNode(ListNode head){
	        if(head == null || head.next == null)
	            return head;
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
}
