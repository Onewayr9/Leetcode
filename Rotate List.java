/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int length=0;
        ListNode node = head;
        while(node!=null){
            length++;
            node = node.next;
        }
        k = k%length;
        ListNode node2 = head;
        node = head;
        for(int i=0;i<k;i++){
            node2 = node2.next;
        }
        while(node2.next!=null){
            node = node.next;
            node2 = node2.next;
        }
        node2.next = head;
        ListNode H = node.next;
        node.next = null;
        return H;
    }
}