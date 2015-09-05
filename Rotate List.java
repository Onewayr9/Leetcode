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
        if(k==0) return head;
        if(head==null) return head;
        else{
            int sum = 0;
            ListNode now = head;
            while(now!=null){
                sum++;
                now = now.next;
            }
            if(sum==1) return head;
            else if(k%sum==0) return head;
            k%=sum;
            now = head;
            ListNode p1=now,p2=now;
            for(int i=0;now.next!=null;i++){
                if(i==sum-k-1) p1 = now;
                now = now.next;
            }
            p2 = now;
            p2.next = head;
            head = p1.next;
            p1.next = null;
        }
        return head;
    }
}