public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1;i<nums.length;i++){
            ans[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    ans[i] = Math.max(ans[i],ans[j]+1);
                }
            }
        }
        int max = ans[0];
        for(int e:ans){
            max = Math.max(max,e);
        }
        return max;
    }
}
/*Another Sol: DP+Binary Search O(nlogn)*/
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}