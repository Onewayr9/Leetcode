/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(l1.val+l2.val);
        ListNode head = l3;
        while(true)
        {
            if(l1.next==null)
            l1.val=0;
            else
            l1=l1.next;
            if(l2.next==null)
            l2.val=0;
            else
            l2=l2.next;
            if(l3.val>=10)
            {
                l3.val = l3.val%10;
                l3.next = new ListNode(l1.val+l2.val+1);
                if(l1.next==null&&l2.next==null&&l3.next.val==0){
                l3.next=null;
                break;}
                l3 = l3.next;
            }
            else{
                l3.next = new ListNode(l1.val+l2.val);
                if(l1.next==null&&l2.next==null&&l3.next.val==0){
                l3.next=null;
                break;}
                l3 = l3.next;
            }
        }
        return head;
    }
}