public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(Math.abs(nums[i]+nums[l]+nums[r]-target)<Math.abs(ans-target)) ans = nums[i]+nums[l]+nums[r];
                if(nums[i]+nums[l]+nums[r]-target==0){
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]-target<0) l++;
                else r--;
            }
        }
        return ans;
    }
}