/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==0) return head;
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode node = H;
        while(node!=null){
            ListNode fast = node;
            ListNode nextFirst = node.next;
            for(int i=0;i<k&&fast!=null;i++){
                fast = fast.next;
            }
            if(fast!=null){
                ListNode begin = node.next;
                ListNode end = fast.next;
                node.next = end;
                while(begin!=end){
                    ListNode x = begin;
                    begin = begin.next;
                    x.next = node.next;
                    node.next = x;
                }
            }
            node = nextFirst;
        }
        return H.next;
    }
}