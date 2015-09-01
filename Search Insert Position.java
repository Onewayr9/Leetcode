public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        if(target<nums[0]) return 0;
        else if(target>nums[nums.length-1]) return nums.length;
        else{
            int left=0,right=nums.length-1;
            while(left<=right){
                int middle = (left+right)/2;
                if(nums[middle]==target) return middle;
                else if(nums[middle]<target){
                    if(nums[middle+1]>=target) return middle+1;
                    else left = middle+1;
                }else if(nums[middle]>target){
                    if(nums[middle-1]<target) return middle;
                    else right = middle-1;
                }
            }
        }
        return 0;
    }
}