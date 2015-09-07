public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        else if(nums.length==1){
            if(nums[0]==target) return 0;
            else return -1;
        }
        else{
            int left=0,right=nums.length-1;
            int middle=(left+right)/2;
            while(left<=right){
                middle = (left+right)/2;
                if(target==nums[middle]) return middle;
                else if(nums[middle]>=nums[left]&&nums[middle]>=nums[right]){
                    if(target>=nums[left]&&target<nums[middle]) right = middle-1;
                    else left = middle+1;
                }else{
                    if(target>nums[middle]&&target<=nums[right]) left = middle+1;
                    else right = middle-1;
                }
            }
            if(nums[middle]==target) return middle;
            else return -1;
        }
    }
}