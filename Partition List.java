/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        if(head==null||head.next==null) return head;
        else{
            ListNode p1 = newhead;
            ListNode p2 = p1.next;
            while(p2.next!=null){
                if(p2.val>=x&&p2.next.val<x){
                    ListNode temp = p2.next;
                    p2.next = temp.next;
                    temp.next = p1.next;
                    p1.next = temp;
                }else if(p2.next!=null) p2=p2.next;
                if(p1.next.val<x) p1=p1.next;
            }
        }
        return newhead.next;
    }
}