public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = 0;
        if(nums.length==0) return ans;
        else{
            int p1 = 0,p2 = 0,temp = 0,sum = 0;
            while(p2<nums.length){
                sum+=nums[p2];
                temp++;
                if(sum<s) p2++;
                else{
                    if(ans==0||temp<ans) ans = temp;
                    sum-=nums[p1++];
                    temp--;
                    if(p1>p2) p2++;
                    else {
                        sum -= nums[p2];
                        temp--;
                    }
                }
            }
            return ans;
        }
    }
}