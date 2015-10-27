/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);
        String ans = ""+root.val;
        while(queue1.size()!=0||queue2.size()!=0){
            String temp = "";
            if(queue1.size()!=0){
	            while(queue1.size()!=0){
	                TreeNode node = queue1.poll();
	                if(node.left==null){
	                    temp+=",null";
	                }else{
	                    queue2.offer(node.left);
	                    temp+=","+node.left.val;
	                }
	                if(node.right==null){
	                    temp+=",null";
	                }else{
	                    queue2.offer(node.right);
	                    temp+=","+node.right.val;
	                }
	            }
	        }else{
	            while(queue2.size()!=0){
	                TreeNode node = queue2.poll();
	                if(node.left==null){
	                    temp+=",null";
	                }else{
	                    queue1.offer(node.left);
	                    temp+=","+node.left.val;
	                }
	                if(node.right==null){
	                    temp+=",null";
	                }else{
	                    queue1.offer(node.right);
	                    temp+=","+node.right.val;
	                }
	            }
            }
            if(queue1.size()!=0||queue2.size()!=0){
                ans+=temp;
            }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] str = data.split(",");
        if(str[0].equals("null")){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        int index = 1;
        while(index<str.length){
            TreeNode node = queue.poll();
            String leftchild = str[index++];
            String rightchild = str[index++];
            if(!leftchild.equals("null")){
                node.left = new TreeNode(Integer.parseInt(leftchild));
                queue.offer(node.left);
            }
            if(!rightchild.equals("null")){
                node.right = new TreeNode(Integer.parseInt(rightchild));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));