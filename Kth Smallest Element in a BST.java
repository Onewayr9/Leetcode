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
    public int kthSmallest(TreeNode root, int k) {
        int ans = 0;
        for(int i=1;i<k;i++){
            root = removeSmallest(root);}
        while(root.left!=null){
        	root = root.left;
        }
        return root.val;
    }
    public TreeNode removeSmallest(TreeNode root){
        int ans = root.val;
        TreeNode prev = root;
        if(root.left==null){
            root = root.right;
            prev = null;
            return root;
        }else{
            TreeNode node = root.left;
            while(node.left!=null){
                prev = node;
                node = node.left;
            }
            ans = node.val;
            if(node.right==null){
                prev.left = null;
                node = null;
            }
            else{
                prev.left = node.right;
                node = null;
            }
        }
        return root;
    }
}