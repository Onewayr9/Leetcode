public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        int real = (nums[0]+nums[nums.length-1])*(nums[nums.length-1]-nums[0]+1)/2;
        if(real-sum==0&&nums[0]==0)
            return nums[nums.length-1]+1;
        else return real-sum;
    }
}