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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int preleft,int preright,int inleft,int inright){
        if(preleft>preright||inleft>inright){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        int newright = inleft;
        while(inorder[newright]!=preorder[preleft]){
            newright++;
        }
        root.left = build(preorder,inorder,preleft+1,preleft+(newright-inleft),inleft,newright-1);
        root.right = build(preorder,inorder,preleft+(newright-inleft)+1,preright,newright+1,inright);
        return root;
    }
}