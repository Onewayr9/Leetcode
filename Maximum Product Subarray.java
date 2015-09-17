public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        else{
            int[][] ans = new int[nums.length][3];
            ans[0][0] = nums[0];
            ans[0][1] = nums[0];
            ans[0][2] = nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]>0){
                    ans[i][1] = Math.max(nums[i],nums[i]*ans[i-1][1]);
                    ans[i][2] = Math.min(nums[i],nums[i]*ans[i-1][2]);
                }else if(nums[i]<0){
                    ans[i][1] = Math.max(nums[i],nums[i]*ans[i-1][2]);
                    ans[i][2] = Math.min(nums[i],nums[i]*ans[i-1][1]);
                }else{
                    ans[i][1] = 0;
                    ans[i][2] = 0;
                }
                ans[i][0] = Math.max(ans[i-1][0],ans[i][1]);
            }
            return ans[nums.length-1][0];
        }
    }
}