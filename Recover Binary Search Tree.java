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
    TreeNode node1 = null;
    TreeNode node2 = null;
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    TreeNode prev = null;
    public void inorderTraverse(TreeNode root){
        if(root==null) return;
        inorderTraverse(root.left);
        if(prev!=null){
            if(root.val<prev.val){
                if(node1==null){
                    node1=prev;
                }
                node2=root;
            }
        }
        prev = root;
        inorderTraverse(root.right);
    }
}