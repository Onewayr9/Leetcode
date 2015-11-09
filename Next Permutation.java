public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                int left = i-1;
                while(i<=nums.length){
                    if(i==nums.length-1||nums[i+1]<=nums[left]){
                        break;
                    }
                    i++;
                }
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                reverse(nums,left+1,nums.length-1);
                return;
            }
        }
        reverse(nums,0,nums.length-1);
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
/*Time Complexity:O(n) and Space O(n)*/