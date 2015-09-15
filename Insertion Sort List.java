/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        else{
            ListNode p1 = head;
            ListNode p2 = head.next;
            p1.next = null;
            while(p2!=null){
                ListNode temp = p2;
                p2 = p2.next;
                if(temp.val<p1.val){
                    temp.next = p1;
                    head = temp;
                }else{
                    while(p1.next!=null){
                        if(temp.val<p1.next.val){
                            temp.next = p1.next;
                            p1.next = temp;
                            break;
                        }else p1 = p1.next;
                    }
                    if(p1.next==null){
                        temp.next = null;
                        p1.next = temp;
                    }
                }
                p1 = head;
            }
            return head;
        }
    }
}