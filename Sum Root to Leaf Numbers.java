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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    public int sumNumbers(TreeNode root, int temp){
        if(root==null) return 0;
        int cur = 10*temp+root.val;
        if(root.left==null&&root.right==null){
            return cur;
        }else if(root.left==null){
            return sumNumbers(root.right,cur);
        }else if(root.right==null){
            return sumNumbers(root.left,cur);
        }else{
            return sumNumbers(root.left,cur)+sumNumbers(root.right,cur);
        }
    }
}