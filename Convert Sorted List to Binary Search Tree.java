/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        if(list.size()==0) return null;
        else{
            TreeNode root = construction(list,0,list.size()-1);
            return root;
        }
    }
    public TreeNode construction(ArrayList<Integer> list,int left,int right){
        if(left>right) return null;
        else{
            int middle = (left+right)/2;
            TreeNode root = new TreeNode(list.get(middle));
            root.left = construction(list,left,middle-1);
            root.right = construction(list,middle+1,right);
            return root;
        }
    }
}