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
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode node = H;
        while(node.next!=null&&node.next.next!=null){
            if(node.next.next.val!=node.next.val){
                node = node.next;
            }else{
                ListNode node2 = node.next;
                while(node2!=null&&node2.val==node.next.val){
                    node2 = node2.next;
                }
                node.next = node2;
            }
        }
        return H.next;
    }
}