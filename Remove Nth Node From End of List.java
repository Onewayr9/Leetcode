/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode test = head;
        int sum = 0;
        while(test!=null){
            sum++;
            test = test.next;
        }
        int dest = sum - n;
        if(dest<0)
            return null;
        else{
            if(dest == 0){
                test = head;
                head = head.next;
                test = null;
                return head;
            }else{
                dest -= 1;
                ListNode prev = head;
                test = head.next;
                while(dest > 0){
                    prev = prev.next;
                    test = test.next;
                    dest -= 1;
                }
                prev.next = test.next;
                test = null;
            }
        }
        return head;
    }
}