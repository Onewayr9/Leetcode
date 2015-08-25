public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        else if(nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0],nums[1]);
        else if(nums.length==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        else{
            int[] nums1 = Arrays.copyOfRange(nums,0,nums.length-1);
            int[] nums2 = Arrays.copyOfRange(nums,1,nums.length-2);
            return Math.max(robnocircle(nums1),robnocircle(nums2)+nums[nums.length-1]);
        }
    }
    public int robnocircle(int[] nums) {
        int[] ansarray = new int[nums.length];
        if(nums.length==0)
            return 0;
        else if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        else{
            ansarray[0]=nums[0];
            ansarray[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++){
                ansarray[i]=Math.max(ansarray[i-1],ansarray[i-2]+nums[i]);
            }
        }
        return ansarray[nums.length-1];
    }
}