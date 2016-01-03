public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int p1 = 0,p2 = 0,sum = 0,len = Integer.MAX_VALUE;
        for(;p2<nums.length;p2++){
            sum+=nums[p2];
            while(sum>=s){
                len = Math.min(len,p2-p1+1);
                sum -= nums[p1++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}