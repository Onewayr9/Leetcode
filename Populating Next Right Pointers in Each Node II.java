/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean hasNextLevel = false;
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode NextRoot = null;
        while(root!=null){
            if(root.left==null&&root.right==null){
                root = root.next;
                continue;
            }
            if(root.left!=null&&root.right!=null){
                root.left.next = root.right;
                if(!hasNextLevel){
                    hasNextLevel = true;
                    NextRoot = root.left;
                }
            }else if(root.left!=null){
                if(!hasNextLevel){
                    hasNextLevel = true;
                    NextRoot = root.left;
                }
            }else{
                if(!hasNextLevel){
                    hasNextLevel = true;
                    NextRoot = root.right;
                }
            }
            TreeLinkNode node = root.next;
            while(node!=null){
                if(node.left!=null||node.right!=null){
                    if(root.right!=null){
                        if(node.left!=null){
                            root.right.next = node.left;
                        }else{
                            root.right.next = node.right;
                        }
                    }else if(root.right==null&&root.left!=null){
                        if(node.left!=null){
                            root.left.next = node.left;
                        }else{
                            root.left.next = node.right;
                        }
                    }
                    root = node;
                    break;
                }else{
                    node = node.next;
                }
            }
            if(node==null){
                break;
            }
        }
        if(hasNextLevel){
            hasNextLevel = false;
            connect(NextRoot);
        }
    }
}