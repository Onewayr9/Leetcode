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
        if(preorder.length==0) return null;
        else{
            TreeNode root = new TreeNode(preorder[0]);
            buildTree(root,preorder,inorder,0,preorder.length-1,0,inorder.length-1);
            return root;
        }
    }
    public void buildTree(TreeNode root,int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>=preEnd||inStart>=inEnd) return;
        else{
            //System.out.println("a");
            int a = find(root,inorder);
            if(a-inStart>0) root.left = new TreeNode(preorder[preStart+1]);
            if(preStart+(a-inStart)<preEnd) root.right = new TreeNode(preorder[preStart+(a-inStart)+1]);
            if(root.left!=null) buildTree(root.left,preorder,inorder,preStart+1,preStart+(a-inStart),inStart,a-1);
            if(root.right!=null) buildTree(root.right,preorder,inorder,preStart+(a-inStart)+1,preEnd,a+1,inEnd);
        }
    }
    public int find(TreeNode a,int[] arr){
        int ans = 0;
        for(;ans<arr.length;ans++){
            if(arr[ans]==a.val) return ans;
        }
        return ans;
    }
}