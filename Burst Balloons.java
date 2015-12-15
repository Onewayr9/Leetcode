public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int left = i==0?1:nums[i-1];
            int right = i==nums.length-1?1:nums[i+1];
            dp[i][i] = left*nums[i]*right;
            for(int j=i+1;j<nums.length;j++){
                right = j==nums.length-1?1:nums[j+1];
                for(int k=i;k<=j;k++){
                    int addleft = k==i?0:dp[i][k-1];
                    int addright = k==j?0:dp[k+1][j];
                    int addthis = nums[k]*left*right;
                    dp[i][j] = Math.max(dp[i][j],addleft+addthis+addright);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}