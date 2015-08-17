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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        String temp = "";
        if(root==null)
            return ans;
        binaryTreePaths(root,ans,temp);
        return ans;
    }
    public void binaryTreePaths(TreeNode root, List<String> ans, String temp){
        if(root.left==null&&root.right==null){
            temp = temp + root.val + "";
            ans.add(temp);
        }
        else{
            temp = temp + root.val + "->";
            if(root.left!=null)
                binaryTreePaths(root.left,ans,temp);
            if(root.right!=null)
                binaryTreePaths(root.right,ans,temp);
        }
    }
}