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
        if(head==null||head.next==null) return head;
        else{
            ListNode node = head;
            head = head.next;
            ListNode temp = head;
            node.next = temp.next;
            temp.next = node;
            ListNode pre = node;
            node = node.next;
            while(node!=null&&node.next!=null){
                temp = node.next;
                node.next = temp.next;
                temp.next = node;
                pre.next = temp;
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}