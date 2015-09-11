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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return ans;
        else{
            Stack<TreeNode> stack_1 = new Stack<TreeNode>();
            Stack<TreeNode> stack_2 = new Stack<TreeNode>();
            stack_1.push(root);
            while(!stack_1.empty()||!stack_2.empty()){
                List<Integer> temp = new ArrayList<Integer>();
                if(!stack_1.empty()){
                    while(!stack_1.empty()){
                        TreeNode a = stack_1.pop();
                        temp.add(a.val);
                        if(a.left!=null) stack_2.push(a.left);
                        if(a.right!=null) stack_2.push(a.right);
                    }
                    ans.add(temp);
                }else if(!stack_2.empty()){
                    while(!stack_2.empty()){
                        TreeNode a = stack_2.pop();
                        temp.add((a.val));
                        if(a.right!=null) stack_1.push(a.right);
                        if(a.left!=null) stack_1.push(a.left);
                    }
                    ans.add(temp);
                }
            }
            return ans;
        }
    }
}