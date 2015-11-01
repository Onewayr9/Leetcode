/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
 
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
 
        while(p1 != null && p2 != null){
          if(p1.val <= p2.val){
              p.next = p1;
              p1 = p1.next;
          }else{
              p.next = p2;
              p2 = p2.next;
          }
 
          p = p.next;
        }
 
        if(p1 != null)
            p.next = p1;
        if(p2 != null)
            p.next = p2;
 
        return fakeHead.next;
    }
}
/*Another Solution---Using heap*/
public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        for(int i=0;i<lists.length;i++){
            ListNode head = new ListNode(0);
            head.next = lists[i];
            lists[i] = head;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
            });
        for(int i=0;i<lists.length;i++){
            ListNode head = lists[i];
            while(head.next!=null){
                heap.offer(head.next);
                head.next = head.next.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(heap.size()!=0){
            node.next = heap.poll();
            node = node.next;
        }
        node.next = null;
        return head.next;
    }