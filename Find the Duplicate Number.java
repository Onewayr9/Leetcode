public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1,right = len-1;
        while(left<right){
            int mid = (left+right)/2;
            int count = 0;
            for(int i=0;i<len;i++){
                if(nums[i]<=mid) count++;
            }
            if(count>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}