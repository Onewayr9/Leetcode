public class Solution {
    public int maxProduct(int[] nums) {
       int[] max = new int[nums.length];
       int[] min = new int[nums.length];
       int ans = nums[0];
       max[0] = nums[0];
       min[0] = nums[0];
       for(int i=1;i<nums.length;i++){
           if(nums[i]>=0){
               max[i] = Math.max(nums[i],max[i-1]*nums[i]);
               min[i] = Math.min(nums[i],min[i-1]*nums[i]);
           }else{
               max[i] = Math.max(nums[i],min[i-1]*nums[i]);
               min[i] = Math.min(nums[i],max[i-1]*nums[i]);
           }
           ans = Math.max(ans,max[i]);
       }
       return ans;
    }
}