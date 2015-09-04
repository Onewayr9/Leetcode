public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        if(nums[0]==0&&nums.length>1) return false;
        int base = 0;
        while(base+nums[base]<nums.length-1){
            for(int i=1;i<=nums[base];i++){
                if(nums[base+i]+base+i>base+nums[base]){
                    base+=i;
                    break;
                }
                if(i==nums[base]&&nums[base+i]==0) return false;
            }
        }
        return true;
    }
}