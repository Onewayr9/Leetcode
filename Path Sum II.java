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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        pathSum(root,sum,temp);
        return ans;
    }
    public void pathSum(TreeNode root, int sum, List<Integer> temp){
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                List<Integer> temp2 = new ArrayList<>();
                temp2.addAll(temp);
                ans.add(temp2);
            }
        }
        pathSum(root.left,sum-root.val,temp);
        pathSum(root.right,sum-root.val,temp);
        temp.remove(temp.size()-1);
    }
}