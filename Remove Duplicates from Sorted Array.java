public class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = 1;
        if(nums.length==0||nums.length==1)
            return nums.length;
        else{
            int pointer1 = 0, pointer2 = 1;
            for(;pointer2<nums.length;pointer2++){
                if(nums[pointer1]!=nums[pointer2]){
                    nums[ans++]=nums[pointer2];
                    pointer1=pointer2;
                }
            }
        }
        return ans;
    }
}