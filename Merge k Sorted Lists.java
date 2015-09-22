/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        return mergeKLists(lists,0,len-1);
    }
    public ListNode mergeKLists(ListNode[] lists, int left, int right){
        if(left>right) return null;
        else if(left==right) return lists[left];
        else if(right==left+1) return mergeTwoLists(lists[left],lists[right]);
        else{
            int middle = (left+right)/2;
            ListNode l1 = mergeKLists(lists,left,middle);
            ListNode l2 = mergeKLists(lists,middle+1,right);
            return mergeTwoLists(l1,l2);
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null) p.next = l1;
        else p.next = l2;
        return head.next;
    }
}