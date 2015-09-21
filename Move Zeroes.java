public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<=1) return;
        else{
            int p1=0,p2=0;
            for(;p2<nums.length;p2++){
                if(nums[p1]!=0) p1++;
                else{
                    if(nums[p2]!=0){
                        nums[p1] = nums[p2];
                        nums[p2] = 0;
                        p1++;
                    }
                }
            }
        }
    }
}