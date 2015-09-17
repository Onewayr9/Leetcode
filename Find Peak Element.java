public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        else{
            int left = 0,right = nums.length-1;
            if(nums[right]>nums[right-1]) return right;
            if(nums[left]>nums[1]) return left;
            while(left<=right){
                int middle = (left+right)/2;
                if(middle == 0) return 1;
                if(middle == nums.length-1) return nums.length-2;
                if(nums[middle]>nums[middle-1]&&nums[middle]>nums[middle+1]) return middle;
                else if(nums[middle]<nums[middle-1]) right = middle - 1;
                else left = middle + 1;
            }
            return left;
        }
    }
}