/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        else{
            ListNode newhead = new ListNode(0);
            newhead.next = head;
            ListNode p1 = newhead;
            ListNode p2 = p1.next;
            int num = p2.val;
            int time = 1;
            p2 = p2.next;
            while(p2!=null){
                if(p2.val!=num){
                    if(time==1) p1 = p1.next;
                    p1.next = p2;
                    num = p2.val;
                    time = 1;
                }else time = 0;
                p2 = p2.next;
            }
            if(time==1) p1 = p1.next;
            p1.next = p2;
            return newhead.next;
        }
    }
}