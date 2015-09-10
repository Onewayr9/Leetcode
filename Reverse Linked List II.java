/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        else{
            ListNode newhead = new ListNode(0);
            newhead.next = head;
            ListNode p = newhead;
            for(int i=0;i<m-1;i++)
                p = p.next;
            ListNode p2 = p.next;
            p.next = null;
            ListNode p3 = p2;
            for(int i=m;i<=n;i++){
                ListNode x = p3;
                p3 = p3.next;
                x.next = p.next;
                p.next = x;
            }
            p2.next = p3;
            return newhead.next;
        }
    }
}