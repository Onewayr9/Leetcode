public class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int time = 0;
        int i=0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]) i+=2;
            else {
                ans[time++]=nums[i];
                i+=1;
            }
            if(time>1) return ans;
        }
        if(time==0){
            ans[0] = nums[nums.length-2];
            ans[1] = nums[nums.length-1];
        }else if(time==1) ans[1] = nums[nums.length-1];
        return ans;
    }
}