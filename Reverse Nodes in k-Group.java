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
        if(head==null||head.next==null||k<=1) return head;
        else{
            int len = 0;
            ListNode p = head;
            while(p!=null){
                len++;
                p = p.next;
            }
            if(k>len) return head;
            ListNode H = new ListNode(0);
            H.next = null;
            ListNode p1 = head;
            ListNode headtemp = head;
            for(int i=0;i<=len-k;i+=k){
                ListNode p2 = p1;
                for(int j=i;j<i+k-1;j++){
                    p2 = p2.next;
                }
                if(i==0) head = p2;
                else{
                    headtemp.next = p2;
                    headtemp = p1;
                }
                p2 = p2.next;
                H.next = p2;
                while(p1!=p2){
                    ListNode x = p1;
                    p1 = p1.next;
                    x.next = H.next;
                    H.next = x;
                }
            }
            return head;
        }
    }
}