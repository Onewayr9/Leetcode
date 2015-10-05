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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> hasDiscovered = new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(hasDiscovered.contains(node)){
                ans.add(node.val);
                stack.pop();
            }else{
                hasDiscovered.add(node);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        return ans;
    }
}