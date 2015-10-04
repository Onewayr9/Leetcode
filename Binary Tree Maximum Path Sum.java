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
    int ans = 0;
    int max = 0;
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        calPathSum(root,max);
        return max[0];
    }
    public int calPathSum(TreeNode root, int[] max){
        if(root==null){
            return 0;
        }
        int left = calPathSum(root.left,max);
        int right = calPathSum(root.right,max);
        int current = Math.max(root.val,root.val+Math.max(left,right));
        max[0] = Math.max(max[0],Math.max(current,left+root.val+right));
        return current;
    }
}