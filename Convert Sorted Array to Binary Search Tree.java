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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        else{
            TreeNode root = construction(nums,0,nums.length-1);
            return root;
        }
    }
    public TreeNode construction(int[] nums,int left,int right){
        if(left>right) return null;
        else{
            int middle = (left+right)/2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = construction(nums,left,middle-1);
            root.right = construction(nums,middle+1,right);
            return root;
        }
    }
}