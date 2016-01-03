public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num:nums){
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);
        int[] ans = new int[2];
        Arrays.fill(ans,0);
        for(int num:nums){
            if((num&diff)==0){
                ans[0]^=num;
            }else{
                ans[1]^=num;
            }
        }
        return ans;
    }
}