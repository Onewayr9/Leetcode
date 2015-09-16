/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        else{
            ListNode p = head;
            int len = 0;
            while(p!=null){
                p = p.next;
                len++;
            }
            head = mergesort(head,len);
            return head;
        }
    }
    public ListNode mergesort(ListNode head,int len){
        if(len==1) return head;
        else{
            ListNode p = head;
            for(int i=1;i<len/2;i++)
                p = p.next;
            ListNode head2 = p.next;
            p.next = null;
            head = mergesort(head,len/2);
            head2 = mergesort(head2,len-len/2);
            //System.out.println(head.val+" "+head2.val);
            return merge(head,head2);
        }
    }
    public ListNode merge(ListNode head,ListNode head2){
        ListNode p1 = head;
        ListNode p2 = head2;
        ListNode newhead = new ListNode(0);
        ListNode p = newhead;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1!=null) p.next = p1;
        if(p2!=null) p.next = p2;
        return newhead.next;
    }
}