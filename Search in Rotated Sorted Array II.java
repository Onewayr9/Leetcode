public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        else if(nums.length==1) return nums[0]==target;
        else{
            int left=0,right=nums.length-1;
            int middle=(left+right)/2;
            while(left<=right){
                middle = (left+right)/2;
                if(left<right&&nums[right]==nums[right-1]) right--;
                else if(left<right&&nums[left]==nums[left+1]) left++;
                else{
                    if(target==nums[middle]) return true;
                    else if(nums[middle]>=nums[left]&&nums[middle]>=nums[right]){
                        if(target>=nums[left]&&target<nums[middle]) right = middle-1;
                        else left = middle+1;
                    }else{
                        if(target>nums[middle]&&target<=nums[right]) left = middle+1;
                        else right = middle-1;
                    }
                }
            }
            return nums[middle]==target;
        }
    }
}