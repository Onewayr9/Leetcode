public class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        while(left<=right){
            if(left==right||nums[left]<nums[right]){
                return nums[left];
            }else if(right-left==1){
                return nums[right];
            }
            int mid = (left+right)/2;
            if(nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]>nums[left]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return nums[left];
    }
}