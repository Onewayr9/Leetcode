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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        while(!stack.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                temp.add(node.val);
                if(i%2==1){
                    if(node.right!=null) list.add(node.right);
                    if(node.left!=null) list.add(node.left);
                }else{
                    if(node.left!=null) list.add(node.left);
                    if(node.right!=null) list.add(node.right);
                }
            }
            ans.add(temp);
            for(TreeNode node:list){
                stack.push(node);
            }
            i++;
        }
        return ans;
    }
}