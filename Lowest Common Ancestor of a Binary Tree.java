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
    List<TreeNode> plist = new ArrayList<>();
    List<TreeNode> qlist = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root,p,plist);
        find(root,q,qlist);
        for(int i=0,j=0;i<plist.size()&&j<qlist.size();i++,j++){
            if(plist.get(i)!=qlist.get(j)){
                return plist.get(i-1);
            }
        }
        return plist.size()>qlist.size()?qlist.get(qlist.size()-1):plist.get(plist.size()-1);
    }
    public boolean find(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root==null){
            return false;
        }
        if(root==p||find(root.left,p,list)||find(root.right,p,list)){
            list.add(0,root);
            return true;
        }else{
            return false;
        }
    }
}

/*better sol*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}