package spatel.algo.linkedList;

import java.util.PriorityQueue;

public class MergeKLinkedList {
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10, (node1, node2) -> node1.val - node2.val);
        
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }
        
        ListNode resultHead = null;
        ListNode resultTail = null;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(resultHead == null){
               resultHead = node;
               resultTail = node; 
            }else{
               resultTail.next = node;
               resultTail = resultTail.next;
            }
            if(node.next != null)
                pq.add(node.next);
        }
        return resultHead;
    }
}
