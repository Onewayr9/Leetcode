public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        else{
            int ans = 1;
            int p1=0,p2=1;
            boolean isDup = false;
            for(;p2<nums.length;p2++){
                ans++;
                if(nums[p2]!=nums[p2-1]){
                    isDup = false;
                    nums[++p1] = nums[p2];
                }
                else if(isDup==false){
                    isDup = true;
                    nums[++p1] = nums[p2];
                }else ans--;
            }
            return ans;
        }
    }
}