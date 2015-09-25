public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int cur = 0;
        int next = 1;
        if(nums.length<=1) return 0;
        else{
            while(cur<nums.length){
                if(cur+nums[cur]>=nums.length-1) return step+1;
                for(int i=cur+1;i<=cur+nums[cur]&&i<nums.length;i++){
                    if(i+nums[i]>next+nums[next])
                        next = i;
                }
                step++;
                cur = next;
                next = cur+1;
                if(cur==nums.length-1) return step;
            }
            return step;
        }
    }
}