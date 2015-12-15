/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode H = new ListNode(0);
        H.next = null;
        while(head!=null){
            ListNode x = head;
            head = head.next;
            x.next = H.next;
            H.next = x;
        }
        return H.next;
    }
}