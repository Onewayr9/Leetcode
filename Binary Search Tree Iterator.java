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
    Stack<TreeNode> stack;
    TreeNode current;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty()||current!=null;
    }

    /** @return the next smallest number */
    public int next() {
        while(current!=null){
            stack.push(current);
            current = current.left;
        }
        TreeNode nex = stack.pop();
        current = nex.right;
        return nex.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */