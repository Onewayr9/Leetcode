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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        else{
            int temp=0;
            sumNumbers(root,temp);
            return sum;
        }
    }
    public void sumNumbers(TreeNode root,int temp){
        if(root.right==null&&root.left==null) sum += 10*temp+root.val;
        else{
            if(root.left!=null) sumNumbers(root.left,10*temp+root.val);
            //System.out.println(sum);
            if(root.right!=null) sumNumbers(root.right,10*temp+root.val);
        }
    }
}