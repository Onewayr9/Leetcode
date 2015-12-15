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
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,1);
        return ans;
    }
    public void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(ans.size()<level){
            ans.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}