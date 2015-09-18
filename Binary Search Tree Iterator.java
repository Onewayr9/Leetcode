/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> node = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        Iterator(root);
    }
    public void Iterator(TreeNode root){
        if(root==null) return;
        else{
            Iterator(root.right);
            node.push(root);
            Iterator(root.left);
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!node.empty());
    }

    /** @return the next smallest number */
    public int next() {
        return node.pop().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */