/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow){
            if(fast==null||fast.next==null) return null;
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = head;
        while(fast!=slow.next){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}