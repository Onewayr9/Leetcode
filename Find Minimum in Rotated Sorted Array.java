public class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        else if(nums[0]<nums[nums.length-1]) return nums[0];
        else{
            int left = 0;
            int right = nums.length-1;
            while(left<=right){
                int middle = (left+right)/2;
                if(middle==nums.length-1) return nums[0];
                else if(middle==0) return nums[1];
                else{
                    if(nums[middle]<nums[middle-1]) return nums[middle];
                    if(nums[middle]>nums[middle-1]&&nums[middle]>nums[middle+1]) return nums[middle+1];
                    else if(nums[middle-1]>nums[right]) left = middle+1;
                    else right = middle - 1;
                }
            }
            return nums[left+1];
        }
    }
}