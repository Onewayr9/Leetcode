public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0],temp = 0;
        if(nums.length==0) return 0;
        else{
            for(int i=0;i<nums.length;i++){
                temp+=nums[i];
                if(temp>max) max=temp;
                if(temp<0) temp=0;
            }
        }
        return max;
    }
}