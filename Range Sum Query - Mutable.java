public class NumArray {
    TreeNode root = null;
    public NumArray(int[] nums) {
        if(nums.length>0){
            this.root = buildTree(nums,0,nums.length-1);
        }
    }
    
    public TreeNode buildTree(int[] nums,int begin,int end){
        TreeNode node = new TreeNode(begin,end);
        if(begin==end){
            node.sum = nums[begin];
            return node;
        }
        int mid = (begin+end)/2;
        node.left = buildTree(nums,begin,mid);
        node.right = buildTree(nums,mid+1,end);
        node.sum = node.left.sum+node.right.sum;
        return node;
    } 

    void update(int i, int val) {
        update(root, i, val);
    }
    
    void update(TreeNode root, int i, int val){
        if(root.start==i&&root.end==i){
            root.sum = val;
        }else{
            int mid = (root.start+root.end)/2;
            if(i<=mid){
                update(root.left,i,val);
            }else{
                update(root.right,i,val);
            }
            root.sum = root.left.sum+root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }
    
    public int sumRange(TreeNode root, int i, int j){
        if(root.start==i&&root.end==j){
            return root.sum;
        }
        int mid = (root.start+root.end)/2;
        if(i>mid){
            return sumRange(root.right,i,j);
        }else if(j<=mid){
            return sumRange(root.left,i,j);
        }else{
            return sumRange(root.left,i,mid)+sumRange(root.right,mid+1,j);
        }
    }
}
class TreeNode {
    int start;
    int end;
    TreeNode left;
    TreeNode right;
    int sum;
    public TreeNode(int start,int end){
        this.start = start;
        this.end = end;
        this.sum = 0;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);