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
        if(root==null) return ans;
        else{
            rightSideView(root,1);
            return ans;
        }
    }
    public void rightSideView(TreeNode root,int layer){
        if(root==null) return;
        else{
            if(ans.size()<layer){
                ans.add(root.val);
            }
            rightSideView(root.right,layer+1);
            rightSideView(root.left,layer+1);
        }
    }
}