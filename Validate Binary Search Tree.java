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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }
    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null) 
            return true;
        if(p.val <= min || p.val >= max)
            return false;
        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}