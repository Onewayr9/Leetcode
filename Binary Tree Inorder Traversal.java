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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> store = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        else{
            store.push(root);
            while(!store.empty()){
                TreeNode node = store.peek();
                if(node.left!=null&&!set.contains(node.left)) store.push(node.left);
                else if(node.left==null||set.contains(node.left)){
                    store.pop();
                    set.add(node);
                    ans.add(node.val);
                    if(node.right!=null) store.push(node.right);
                }
            }
            return ans;
        }
    }
}