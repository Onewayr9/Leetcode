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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tempans = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        return pathSum(root,sum,tempans,ans);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> tempans, List<List<Integer>> ans){
        if(root==null)
            return ans;
        else{
            sum-=root.val;
            tempans.add(root.val);
            if(root.left==null&&root.right==null){
                if(sum==0)
                    ans.add(new ArrayList<Integer>(tempans));
            }else{
                if(root.left!=null){
                pathSum(root.left,sum,tempans,ans);
                tempans.remove(tempans.size()-1);
                }
                if(root.right!=null){
                pathSum(root.right,sum,tempans,ans);
                tempans.remove(tempans.size()-1);
                }
            }
        }
        return ans;
    }
}