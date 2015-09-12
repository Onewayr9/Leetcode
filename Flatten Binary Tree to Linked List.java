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
    public void flatten(TreeNode root) {
        if(root==null) return;
        else{
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = root;
            while(node!=null||!stack.empty()){
                if(node.right!=null) stack.push(node.right);
                if(node.left!=null){
                    node.right = node.left;
                    node.left = null;
                }else if(!stack.empty()){
                    node.right = stack.pop();
                }
                node = node.right;
            }
        }
    }
}