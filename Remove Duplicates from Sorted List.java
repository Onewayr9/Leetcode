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
        ListNode p1 = head;
        while(p1!=null&&p1.next!=null){
            if(p1.val==p1.next.val){
                ListNode p2 = p1.next;
                while(p2!=null&&p2.val==p1.val){
                    p2 = p2.next;
                }
                p1.next = p2;
            }
            p1 = p1.next;
        }
        return head;
    }
}