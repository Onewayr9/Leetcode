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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        else{
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.empty()){
                TreeNode node = stack.pop();
                ans.add(node.val);
                if(node.right!=null) stack.push(node.right);
                if(node.left!=null) stack.push(node.left);
            }
            return ans;
        }
    }
}