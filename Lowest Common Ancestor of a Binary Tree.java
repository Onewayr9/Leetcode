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
    //2, 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        
        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();
        pathp.add(root);
        pathq.add(root);
        
        getPath(root, p, pathp);
        getPath(root, q, pathq);
        
        TreeNode lca = null;
        for(int i=0; i<pathp.size() && i<pathq.size(); i++) {
            if(pathp.get(i) == pathq.get(i)) lca = pathp.get(i);
            else break;
        }
        return lca;
    }
    
    private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {
        if(root==n) {
            return true;
        }
        
        if(root.left!=null) {
            path.add(root.left);
            if(getPath(root.left, n, path)) return true;
            path.remove(path.size()-1);
        }
        
        if(root.right!=null) {
            path.add(root.right);
            if(getPath(root.right, n, path)) return true;
            path.remove(path.size()-1);
        }
        
        return false;
    }
}