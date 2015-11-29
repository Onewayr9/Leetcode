/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return;
        }
        TreeLinkNode nextLevel = root;
        while(nextLevel!=null){
            TreeLinkNode node = nextLevel;
            nextLevel = null;
            TreeLinkNode prev = null;
            while(node!=null){
                if(!(node.left==null&&node.right==null)){
                    if(nextLevel==null){
                        nextLevel = node.left==null?node.right:node.left;
                    }
                    if(prev!=null){
                        prev.next = node.left==null?node.right:node.left;
                    }
                    if(node.left!=null&&node.right!=null){
                        node.left.next = node.right;
                    }
                    prev = node.right==null?node.left:node.right;
                }
                node = node.next;
            }
        }
    }
}