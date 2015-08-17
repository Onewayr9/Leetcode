public class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        if(nums.length==0)
            return nums.length;
        else{
            Arrays.sort(nums);
            for(int pointer=0;pointer<nums.length;pointer++){
                if(nums[pointer]!=val)
                    nums[ans++]=nums[pointer];
            }
        }
        return ans;
    }
}