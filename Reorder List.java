/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        else{
            ListNode p = head;
            int len = 0;
            while(p!=null){
                p = p.next;
                len++;
            }
            p = head;
            for(int i=1;i<(len+1)/2;i++){
                p = p.next;
            }
            ListNode nexthead = p.next;
            p.next = null;
            /*reverse the next half list*/
            p = nexthead;
            ListNode H = new ListNode(0);
            H.next = null;
            while(p!=null){
                ListNode temp = p;
                p = p.next;
                temp.next = H.next;
                H.next = temp;
            }
            nexthead = H.next;
            /*merge two LinkLists*/
            ListNode p1 = head;
            ListNode p2 = nexthead;
            while(p1!=null&&p2!=null){
                ListNode temp = p2;
                p2 = p2.next;
                temp.next = p1.next;
                p1.next = temp;
                p1 = temp.next;
            }
        }
    }
}