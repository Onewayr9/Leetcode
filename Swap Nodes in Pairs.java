/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode node = H;
        while(node.next!=null&&node.next.next!=null){
            ListNode node1 = node.next;
            ListNode node2 = node.next.next;
            node1.next = node2.next;
            node2.next = node1;
            node.next = node2;
            node = node1;
        }
        return H.next;
    }
}