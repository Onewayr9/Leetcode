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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        else{
            TreeNode root = new TreeNode(postorder[postorder.length-1]);
            buildTree(root,inorder,postorder,0,inorder.length-1,0,postorder.length-1);
            return root;
        }
    }
    public void buildTree(TreeNode root,int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd){
        if(inStart>=inEnd||postStart>=postEnd) return;
        else{
            int a = 0;
            for(;a<inorder.length;a++)
                if(inorder[a]==root.val) break;
            if(inEnd-a>0) root.right = new TreeNode(postorder[postEnd-1]);
            if(postEnd-(inEnd-a)-1>=postStart) root.left = new TreeNode(postorder[postEnd-(inEnd-a)-1]);
            if(root.left!=null) buildTree(root.left,inorder,postorder,inStart,a-1,postStart,postEnd-(inEnd-a)-1);
            if(root.right!=null) buildTree(root.right,inorder,postorder,a+1,inEnd,postEnd-(inEnd-a),postEnd-1);
        }
    }
}